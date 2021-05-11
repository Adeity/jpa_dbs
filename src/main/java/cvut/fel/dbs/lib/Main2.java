package cvut.fel.dbs.lib;

import javax.persistence.*;
import java.util.List;

public class Main2 {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        EntityManager em = emf.createEntityManager();
        Book b1 = em.find(Book.class, 2);
        System.out.println(b1.id);
        System.out.println(b1.title);

        TypedQuery<Book> q2 = em.createQuery(
                "SELECT b FROM Book as b",
                Book.class
        );
        List<Book> l = q2.getResultList();
        for (Book b : l) {
            System.out.println("Id: " + b.id + " | Title: " + b.title);
        }

        EntityTransaction et = em.getTransaction();

        et.begin();
        Book b4 = new Book();
        b4.title = "Amerika";
        em.persist(b4);
        et.commit();

        em.close();
        emf.close();
    }
}

