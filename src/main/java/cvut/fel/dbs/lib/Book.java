package cvut.fel.dbs.lib;

import javax.persistence.*;

@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue
    public Integer id;
    @Column(name ="title", nullable = false)
    public String title;

    //  transient means that this attribute is not included in the database
    @Transient
    public String comment;

    public Book() {
        this.id = null;
        this.title = null;
        this. comment = null;
    }
}
