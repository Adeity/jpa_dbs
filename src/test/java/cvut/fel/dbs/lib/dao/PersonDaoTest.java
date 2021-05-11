//package cvut.fel.dbs.lib.dao;
//
//import cvut.fel.dbs.lib.model.Person;
//import org.junit.*;
//
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.Persistence;
//
//public class PersonDaoTest {
//
//    /////////////////////////////////////////////////////////////////////////////////////////////
//    // Static fields and methods ////////////////////////////////////////////////////////////////
//    /////////////////////////////////////////////////////////////////////////////////////////////
//    private static EntityManagerFactory emf;
//
//    @BeforeClass
//    public static void initEntityManagerFactory(){
//        emf = Persistence.createEntityManagerFactory("test-pu");
//    }
//
//    @AfterClass
//    public static void closeEntityManagerFactory(){
//        emf.close();
//    }
//
//    /////////////////////////////////////////////////////////////////////////////////////////////
//    // Instance fields and methods //////////////////////////////////////////////////////////////
//    /////////////////////////////////////////////////////////////////////////////////////////////
//
//    private EntityManager em;
//    private PersonDao sut;
//
//
//    @Before
//    public void setUp() throws Exception {
//        em = emf.createEntityManager();
//        em.getTransaction().begin();
//        sut = new PersonDao(em);
//    }
//
//    @After
//    public void afterTest(){
//        em.getTransaction().rollback();
//        em.close();
//    }
//
//    @Test
//    public void createUser() {
//        Person p = new Person();
//        p.setName("Bogdan Kostov");
//        sut.create(p);
//
//        Assert.assertNotNull(p.getId());
//
//        Person p2 = em.find(Person.class, p.getId());
//        Assert.assertEquals(p.getId(), p2.getId());
//        Assert.assertEquals(p.getName(), p2.getName());
//
//    }
//}