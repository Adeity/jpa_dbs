//package cvut.fel.dbs.lib.model;
//
//import javax.persistence.*;
//import java.util.List;
//
//@Entity
//public class Person {
//
//    @Id
//    @GeneratedValue
//    private Long id;
//
//    private String name;
//
//    @ManyToMany(mappedBy = "authors")
//    private List<Book> authoredBooks;
//
//    @OneToMany(mappedBy = "owner")
//    private List<Book> ownedBooks;
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    @Override
//    public String toString() {
//        return "Person{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                '}';
//    }
//}
