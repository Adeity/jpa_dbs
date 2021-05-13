package cvut.fel.dbs.lib.zapocet;
import javax.persistence.*;
import java.util.Collection;
import java.util.List;

/**
 * Teacher is a person that teaches.
 */
@Entity
@Table(name = "teacher")
@DiscriminatorValue("1")
public class Teacher extends Person {

    public Teacher(String pid, String name, String surname, String phonenumber, String street, String city, Integer zipcode) {
        super(pid, name, surname, phonenumber, street, city, zipcode, 1);
    }

    public Teacher() {

    }

    @ManyToMany
    @JoinTable(
            name = "teachessubject",
            joinColumns = @JoinColumn(name = "idperson"),
            inverseJoinColumns = @JoinColumn(name = "idsubject"))
    private Collection<Subject> taughtSubjects;

    public Collection<Subject> getTaughtSubjects() {
        return taughtSubjects;
    }

    public void setTaughtSubjects(Collection<Subject> taughtSubjects) {
        this.taughtSubjects = taughtSubjects;
    }

    /**
     * Returns new teacher instance with attributes
     * @param pid pid of teacher
     * @param name of teacher
     * @param surname of teacher
     * @param phonenumber of teacher
     * @param street teacher is living on
     * @param city teacher lives in
     * @param zipcode teacher lives at
     * @return new teacher instance
     */
    protected static Teacher getNewTeacherInstance(String pid, String name, String surname, String phonenumber, String street, String city, String zipcode) {
        Integer zipcode1 = null;
        if (zipcode.length() != 0) {
            zipcode1 = Integer.parseInt(zipcode);
        }
        Teacher newTeacher = new Teacher(pid, name, surname, phonenumber, street, city, zipcode1);
        return newTeacher;
    }

    /**
     * Find teacher in DB by pid and returns it.
     * @param pid of teacher
     * @return teacher with pid
     */
    protected static List<Teacher> getTeacherByPid(String pid, App app){
        Teacher t;
        TypedQuery<Teacher> q2 = app.em.createQuery(
                "SELECT t FROM Teacher t WHERE t.pid = " + pid,
                Teacher.class
        );
        return q2.getResultList();
    }

    /**
     * Find teacher in DB by id and returns it.
     * @param idperson of teacher
     * @return teacher with idperson
     */
    public static Teacher getTeacherById(String idperson, App app){
        TypedQuery<Teacher> q2 = app.em.createQuery(
                "SELECT t FROM Teacher t WHERE t.idperson = " + idperson,
                Teacher.class
        );
        return q2.getSingleResult();
    }

    /**
     * Finds all teachers in database
     * @return list of all teachers in db
     */
    public static List<Teacher> getListOfTeachers(App app) {
        TypedQuery<Teacher> q2 = app.em.createQuery(
                "SELECT t FROM Teacher t WHERE t.person_type_id = 1",
                Teacher.class
        );
        return q2.getResultList();
    }

}
