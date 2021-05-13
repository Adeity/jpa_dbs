package cvut.fel.dbs.lib.zapocet;



import java.util.List;

/**
 * Controller is controlled in view. It handles all CRUD operations.
 */
public class Controller {
    App app;

    public void setApp(App app) {
        this.app = app;
    }

    /**
     * Deletes teacher from DB with id
     * @param id of teacher
     */
    public void deleteTeacherById(int id) {
        app.et.begin();
        app.em.createQuery("DELETE FROM Teacher WHERE idperson = " + id).executeUpdate();
        app.et.commit();
    }

    /**
     * Returns list of all teachers
     * @return list of teachers in DB
     */
    public List<Teacher> getListOfTeachers() {
        return Teacher.getListOfTeachers(app);
    }

    /**
     * Returns list of all subjects
     * @return list of all subjects
     */
    public List<Subject> getListOfSubjects() {
        return Subject.getListOfSubjects(app);
    }

    /**
     * Validates user input and it is valid it creates new teacher in DB
     * @return true if data was valid and teacher was created in db. false otherwise
     */
    public boolean createNewTeacher(String pid, String name, String surname, String phonenumber, String street, String city, String zipcode) {
        if(!phoneAndZipAreValid(phonenumber, zipcode)) {
            return false;
        }
        if (pid.length() != 10) {
            return false;
        }
        if (name.length() == 0 || pid.length() == 0 || surname.length() == 0) {
            return false;
        }
        if (Teacher.getTeacherByPid(pid, app).size() != 0) {
            System.out.println("Someone with this pid is already in DB");
            return false;
        }
        Teacher t = Teacher.getNewTeacherInstance(pid, name, surname, phonenumber, street, city, zipcode);
        app.et.begin();
        app.em.persist(t);
        app.et.commit();
        return true;
    }

    /**
     * Checks wheter phone and zipcode are in valid format
     * @return true if both are valid. false otherwise
     */
    private boolean phoneAndZipAreValid(String phonenumber, String zipcode) {
        if (phonenumber.length() != 0) {
            if (phonenumber.length() != 9) {
                System.out.println("Wrong phonenumber length. Current phonenumber len is: " + phonenumber.length());
                return false;
            }
        }
        if (zipcode.length() != 0) {
            if (zipcode.length() != 5) {
                System.out.println("Wrong zipcode length. Current zipcode len is: " + zipcode.length());
                return false;
            }
        }
        return true;
    }

    /**
     * updates teachers parameters that is currently in DB
     * @return true if input data were valid and teacher was updated
     */
    public boolean updateTeacher(Teacher t, String pid, String name, String surname, String phonenumber, String street, String city, String zipcode) {
        if(!phoneAndZipAreValid(phonenumber, zipcode)) {
            return false;
        }
        t.setName(name);
        t.setSurname(surname);
        t.setPhoneNumber(phonenumber);
        t.setStreet(street);
        t.setCity(city);

        if (zipcode.equals("")) {
            t.setZipcode(null);
        } else {
            t.setZipcode(Integer.parseInt(zipcode));
        }

        app.et.begin();
        app.em.merge(t);
        app.et.commit();
        return true;
    }

    /**
     * Deletes teachers taugth subject relationship.
     * @param teacherId id of teacher
     * @param subjectId id of subject to be deleted from the relationship
     */
    public void deleteTeachersTaugthSubject(int teacherId, int subjectId) {
        Teacher t = app.em.find(Teacher.class, teacherId);
        System.out.println(t);
        Subject s = app.em.find(Subject.class, subjectId);
        System.out.println(s);

        t.getTaughtSubjects().remove(s);
        app.et.begin();
        app.em.merge(t);
        app.et.commit();
    }

    /**
     * Finds subject by its code
     * @return subject found
     */
    private Subject getSubjectByCode(String subjectCode) {
        return Subject.getSubjectByCode(app, subjectCode);
    }

    /**
     * Checks validity of input data and adds subject to teacher taught subject relationship
     * @return true if subject was added to relationship. false otherwise.
     */
    public boolean addTaugthSubjectToTeacher(Teacher t, String subjectCode) {
        if (subjectCode.length() != 10) {
            System.out.println("Subject code length is: " + subjectCode.length() + " code being: " + subjectCode);
            return false;
        }
        Subject s = getSubjectByCode(subjectCode);
        if (s == null) {
            System.out.println("No subject with code " + subjectCode);
            return false;
        }
        if (t.getTaughtSubjects().contains(s)) {
            System.out.println("Teacher already teaches this subject");
            return false;
        }

        t.getTaughtSubjects().add(s);
        app.et.begin();
        app.em.merge(t);
        app.et.commit();
        return true;
    }
}
