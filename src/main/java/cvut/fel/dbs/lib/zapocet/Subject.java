package cvut.fel.dbs.lib.zapocet;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

/**
 * Subjects are taugth by teachers.
 */
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

    /**
     * This finds and return list of all subjects in db
     * @return list of all subjects in DB
     */
    public static List<Subject> getListOfSubjects(App app) {
        TypedQuery<Subject> q2 = app.em.createQuery(
                "SELECT s FROM Subject s",
                Subject.class
        );
        return q2.getResultList();
    }

    /**
     * This finds single subject by its identifying code
     * @param code of subject
     * @return single subject with code
     */
    public static Subject getSubjectByCode(App app, String code) {
        TypedQuery<Subject> q2 = app.em.createQuery(
                "SELECT s FROM Subject s WHERE s.code = '" + code+"'",
                Subject.class
        );
        return q2.getSingleResult();
    }

    @Override
    public String toString() {
        return "Subject{" +
                "idsubject=" + idsubject +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", recommendedsemester='" + recommendedsemester + '\'' +
                '}';
    }
}
