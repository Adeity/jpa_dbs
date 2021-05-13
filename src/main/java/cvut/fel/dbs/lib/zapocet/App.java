package cvut.fel.dbs.lib.zapocet;

import cvut.fel.dbs.lib.zapocet.view.View;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * Application with controller, view and persistence components.
 */
public class App {
    Controller controller;
    EntityManagerFactory emf;
    EntityManager em;
    EntityTransaction et;
    View view;

    public App() {
        this.controller = new Controller();
        this.emf = Persistence.createEntityManagerFactory("pu");
        this.em = this.emf.createEntityManager();
        this.et = em.getTransaction();
        this.view = new View();
    }

    public Controller getController() {
        return controller;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public EntityManagerFactory getEmf() {
        return emf;
    }

    public void setEmf(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public View getView() {
        return view;
    }

    public void setView(View view) {
        this.view = view;
    }
}
