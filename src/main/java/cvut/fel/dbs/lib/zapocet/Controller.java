package cvut.fel.dbs.lib.zapocet;



import java.util.List;

public class Controller {
    App app;

    public void setApp(App app) {
        this.app = app;
    }

    public void deleteTeacherById(int id) {
        app.et.begin();
        app.em.createQuery("DELETE FROM Teacher WHERE idperson = " + id).executeUpdate();
        app.et.commit();
    }

    public List<Teacher> getListOfTeachers() {
        return Teacher.getListOfTeachers(app);
    }

    public List<Subject> getListOfSubjects() {
        return Subject.getListOfSubjects(app);
    }


    public List<Subject> getListOfTaughtSubjectsByTeacher(String idperson) {
        Teacher teacher = Teacher.getTeacherById(idperson, app);

        for (Subject taughtSubject : teacher.getTaughtSubjects()) {
            System.out.println(taughtSubject);
        }

        return null;
    }

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

    private Subject getSubjectByCode(String subjectCode) {
        return Subject.getSubjectByCode(app, subjectCode);
    }

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
