//package cvut.fel.dbs.lib.dao;
//
//import cvut.fel.dbs.lib.model.Person;
//
//import javax.persistence.EntityManager;
//import java.util.List;
//
//public class PersonDao {
//    private EntityManager entityManager;
//
//    public PersonDao() {
//    }
//
//    public PersonDao(EntityManager entityManager) {
//        this.entityManager = entityManager;
//    }
//
//    public List<Person> findAll(){
//        return entityManager.createQuery("SELECT p FROM Person p", Person.class).getResultList();
//    }
//
//    public void create(Person person){
//        entityManager.persist(person);
//    }
//
//    public Person find(Long id){
//        return entityManager.find(Person.class, id);
//    }
//
//    public Person merge(Person p){
//        return entityManager.merge(p);
//    }
//
//    public void delete(Person p){
//        entityManager.remove(p);
//    }
//}
