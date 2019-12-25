package ir.ansar.education.model.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "role")
public class Person {

    @Id
    @Column(columnDefinition = "NUMBER")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USER_SEQ")
    @SequenceGenerator(name = "USER_SEQ", sequenceName = "USER_SEQ", allocationSize = 1,initialValue = 1)
    private Long id;

    @Basic
    @Column(columnDefinition = "NVARCHAR2(20)")
    private String username;

    @Basic
    @Column(columnDefinition = "NVARCHAR2(20)")
    private String password;

    @Basic
    @Column(columnDefinition = "NVARCHAR2(20)")
    private String name;

    @Basic
    @Column(columnDefinition = "NVARCHAR2(20)")
    private String family;

    @Basic
    @Column
    private Boolean first;

    @Transient
    private String passwordConfirm;

    public Person() {
    }

    public Person(String username, String password, String name, String family) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.family = family;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }
}
