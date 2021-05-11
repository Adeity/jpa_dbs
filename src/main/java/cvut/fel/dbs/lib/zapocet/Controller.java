package cvut.fel.dbs.lib.zapocet;

import cvut.fel.dbs.lib.Book;

import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

public class Controller {
    App app;

    public void setApp(App app) {
        this.app = app;
    }

    public void putNewTeacherToDB(String name) {
        app.et.begin();
//        Teacher t1 = Teacher.getNewTeacherInstance(name);
//        t1.setName(name);
//        app.em.persist(t1);
        app.et.commit();
    }



    private void deleteTeacherById(int id) {
        app.em.createQuery("DELETE FROM teacher WHERE idteacher = " + id).executeUpdate();
    }

    public List<Teacher> getListOfTeachers() {
        return Teacher.getListOfTeachers(app);
    }

    public void updateTeacher() {

    }
}
