package ir.ansar.education.model.entity;

import ir.ansar.education.model.dto.*;


import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity(name = "lecture")
public class Lecture {

    @Id
    @Column(columnDefinition = "NUMBER")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "LEC_SEQ")
    @SequenceGenerator(name = "LEC_SEQ",sequenceName = "LEC_SEQ",allocationSize = 10,initialValue = 1)
    private Long id;

    @Basic
    @Column(columnDefinition = "NVARCHAR2(20)")
    private String lid;

    @Basic
    @Column(columnDefinition = "NVARCHAR2(20)")
    private String name;

    @Basic
    @Column(columnDefinition = "NUMBER")
    private Integer unit;

    @Temporal(TemporalType.DATE)
    private Date since;

    @Temporal(TemporalType.DATE)
    private Date until;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="lecture_students", joinColumns={@JoinColumn(referencedColumnName="ID")}
            , inverseJoinColumns={@JoinColumn(referencedColumnName="ID")})
    private List<Student> students;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id", referencedColumnName = "id",insertable = false,updatable = false)
    private Teacher teach;

    public Lecture(String lid, String name, Integer unit, Date since, Date until) {
        this.lid = lid;
        this.name = name;
        this.unit = unit;
        this.since = since;
        this.until = until;
    }

    public Lecture() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLid() {
        return lid;
    }

    public void setLid(String lid) {
        this.lid = lid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getUnit() {
        return unit;
    }

    public void setUnit(int unit) {
        this.unit = unit;
    }

    public void setUnit(Integer unit) {
        this.unit = unit;
    }

    public Date getSince() {
        return since;
    }

    public void setSince(Date since) {
        this.since = since;
    }

    public Date getUntil() {
        return until;
    }

    public void setUntil(Date until) {
        this.until = until;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Teacher getTeacher() {
        return teach;
    }

    public void setTeacher(Teacher teach) {
        this.teach = teach;
    }
}
