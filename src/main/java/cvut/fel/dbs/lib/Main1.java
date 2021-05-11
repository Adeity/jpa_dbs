package cvut.fel.dbs.lib;

import java.sql.*;

public class Main1 {
    public static void main(String[] args) {
        Connection c;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection(
                    "jdbc:postgresql://slon.felk.cvut.cz:5432/"+CONF.username,
                    CONF.username,
                    CONF.password
            );
//            c.close();

            Statement s1 = c.createStatement();
            s1.execute(
                    "CREATE TABLE IF NOT EXISTS book (id int PRIMARY KEY, title VARCHAR(255))"
            );
//            Statement s2 = c.createStatement();
//            s2.execute(
//                    "INSERT INTO book VALUES (1, 'Proces'), (2, 'Zámek')"
//            );

            Statement s3 = c.createStatement();
            ResultSet rs = s3.executeQuery(
                    "SELECT id, title FROM book"
            );
            while (rs.next()) {
                System.out.println(
                        "Id: " + rs.getInt("id") + " | title: " + rs.getString(2)
                );
            }

            PreparedStatement ps = c.prepareStatement(
                    "SELECT * FROM book WHERE (title = ?)"
            );
            ps.setString(1, "Zámek");
            System.out.println(ps);

            ResultSet rs2 = ps.executeQuery();
            while (rs2.next()) {
                System.out.println(
                        "Id: " + rs2.getInt("id") + " | title: " + rs2.getString(2)
                );
            }
        }

        catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
