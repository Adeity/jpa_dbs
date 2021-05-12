package cvut.fel.dbs.lib.zapocet;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "teacher")
@DiscriminatorValue("1")
public class Teacher extends Person {

    public Teacher(String pid, String name, String surname, String phonenumber, String street, String city, Integer zipcode) {
        super(pid, name, surname, phonenumber, street, city, zipcode, 1);
    }

    public Teacher() {

    }

    protected static Teacher getNewTeacherInstance(String pid, String name, String surname, String phonenumber, String street, String city, String zipcode) {
        Integer zipcode1 = null;
        if (zipcode.length() != 0) {
            zipcode1 = Integer.parseInt(zipcode);
        }
        Teacher newTeacher = new Teacher(pid, name, surname, phonenumber, street, city, zipcode1);
        return newTeacher;
    }

    protected static List<Teacher> getTeacherByPid(String pid, App app){
        Teacher t;
        TypedQuery<Teacher> q2 = app.em.createQuery(
                "SELECT t FROM Teacher t WHERE t.pid = " + pid,
                Teacher.class
        );
        return q2.getResultList();
    }

    public static Teacher getTeacherById(String idperson, App app){
        TypedQuery<Teacher> q2 = app.em.createQuery(
                "SELECT t FROM Teacher t WHERE t.idperson = " + idperson,
                Teacher.class
        );
        return q2.getSingleResult();
    }

    public static List<Teacher> getListOfTeachers(App app) {
        TypedQuery<Teacher> q2 = app.em.createQuery(
                "SELECT t FROM Teacher t WHERE t.person_type_id = 1",
                Teacher.class
        );
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
