package ir.ansar.education.model.entity;

import javax.persistence.*;
import java.util.List;

@Entity(name = "teacher")
@DiscriminatorValue("T")
public class Teacher extends Person{
    @Id
    @Column(columnDefinition = "NUMBER")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TEA_SEQ")
    @SequenceGenerator(name = "TEA_SEQ", sequenceName = "TEA_SEQ", allocationSize = 1, initialValue = 1)
    private Long id;

    @Basic
    @Column(columnDefinition = "NVARCHAR2(20)")
    private String tid;

    @Basic
    @Column(columnDefinition = "NUMBER")
    private Long salary;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "teach")
    private List<Lecture> lectures;

    public Teacher(String tid, Long salary) {
        this.tid = tid;

    }

    public Teacher() {
    }

    public List<Lecture> getLectures() {
        return lectures;
    }

    public void setLectures(List<Lecture> lectures) {
        this.lectures = lectures;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }
}
