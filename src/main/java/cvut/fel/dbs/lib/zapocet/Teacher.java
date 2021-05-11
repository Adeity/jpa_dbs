package cvut.fel.dbs.lib.zapocet;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "teacher")
@DiscriminatorValue("23")
public class Teacher extends Person {

    public Teacher() {
    }

    protected static Teacher getNewTeacherInstance(String name) {
        Teacher newTeacher = new Teacher();
        return newTeacher;
    }

    public static List<Teacher> getListOfTeachers(App app) {
        TypedQuery<Teacher> q2 = app.em.createQuery(
                "SELECT t FROM Teacher t",
                Teacher.class
        );
        System.out.println(app.em.createQuery("SELECT t FROM Teacher t"));
        return q2.getResultList();
    }
//    @Override
//    public String toString() {
//        return "Teacher{" +
//                "idperson=" + idperson +
//                ", pid='" + pid + '\'' +
//                ", name='" + name + '\'' +
//                ", surname='" + surname + '\'' +
//                ", phoneNumber='" + phoneNumber + '\'' +
//                ", street='" + street + '\'' +
//                ", city='" + city + '\'' +
//                ", zipcode=" + zipcode +
//                '}';
//    }
}
