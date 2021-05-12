package cvut.fel.dbs.lib.zapocet;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "subject")
public class Subject {
    @Id
    @GeneratedValue
    public Integer idsubject;

    private String code;

    private String name;

    private String description;

    private String recommendedsemester;

    @ManyToMany(mappedBy = "taughtSubjects")
    private Collection<Teacher> employees;


    public Integer getIdsubject() {
        return idsubject;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getRecommendedsemester() {
        return recommendedsemester;
    }
}
