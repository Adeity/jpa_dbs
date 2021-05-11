//package cvut.fel.dbs.lib;
//
//import cvut.fel.dbs.lib.dao.PersonDao;
//import cvut.fel.dbs.lib.model.Person;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.Persistence;
//import java.util.List;
//
//public class Application {
//
//    private static final Logger LOG = LoggerFactory.getLogger(Application.class);
//
//    private EntityManagerFactory emf;
//    private EntityManager em;
//    private PersonDao personDao;
//
//    public void run(){
//        setup();
//        workWithDB();
//        close();
//    }
//
//    public void setup(){
//        // create emf
//        emf = Persistence.createEntityManagerFactory("pu");
//        // create entity manager
//        em = emf.createEntityManager();
//        // create Person dao
//        personDao = new PersonDao(em);
//    }
//
//    public void close(){
//        em.close();
//        emf.close();
//    }
//
//    public void workWithDB(){
//        em.getTransaction().begin();
//        List<Person> people = personDao.findAll();
//        em.getTransaction().commit();
//        LOG.info("Listing all users {}... ", people.size());
//
//        for(Person p : people){
//            LOG.info(p.toString());
//        }
//
//        LOG.info("Generating 10 users.");
//        for (int i = 0; i < 10; i ++){
//            Person p = new Person();
//            p.setName("Name - " + System.currentTimeMillis());
//            em.getTransaction().begin();
//            personDao.create(p);
//            em.getTransaction().commit();
//        }
//
//        LOG.info("END");
//    }
//
//
//    public static void main(String[] args) {
//        new Application().run();
//    }
//}
