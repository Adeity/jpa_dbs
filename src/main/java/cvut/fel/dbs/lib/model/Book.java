//package cvut.fel.dbs.lib.model;
//
//import javax.persistence.*;
//import java.util.List;
//
//@Entity
//public class Book {
//
//    @Id
//    @GeneratedValue
//    private Long id;
//
//    private String title;
//
//    @ManyToMany
//    private List<Person> authors;
//
//    @ManyToOne
//    private Person owner;
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public List<Person> getAuthors() {
//        return authors;
//    }
//
//    public void setAuthors(List<Person> authors) {
//        this.authors = authors;
//    }
//
//    public Person getOwner() {
//        return owner;
//    }
//
//    public void setOwner(Person owner) {
//        this.owner = owner;
//    }
//}
