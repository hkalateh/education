package ir.ansar.education.model.entity;

import javax.persistence.*;
import java.util.List;

@Entity(name = "student")
@DiscriminatorValue("S")
public class Student extends Person{
    @Id
    @Column(columnDefinition = "NUMBER")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "PER_SEQ")
    @SequenceGenerator(name = "PER_SEQ",sequenceName = "PER_SEQ",allocationSize = 2,initialValue = 1)
    private Long id;

    @Basic
    @Column(columnDefinition = "NVARCHAR2(20)")
    private String sid;

    @Basic
    @Column(columnDefinition = "NVARCHAR2(20)")
    private String nc;

    @ManyToMany(cascade = CascadeType.ALL,mappedBy = "students")
    private List<Lecture> lectures;

    public Student() {
    }

    public Student(String nc,String sid) {
        this.nc=nc;
        this.sid=sid;
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

    public String getNc() {
        return nc;
    }

    public void setNc(String nc) {
        this.nc = nc;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }
}
