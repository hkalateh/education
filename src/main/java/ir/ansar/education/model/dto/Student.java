package ir.ansar.education.model.dto;

import java.io.Serializable;

public class Student extends Person implements Serializable {

    private String nc;
    private String sid;

    public Student(String nc, String sid) {
        this.nc = nc;
        this.sid = sid;
    }

    public Student(String uid, String username, String password, String name, String family, String nc, String sid) {
        super(uid, username, password, name, family);
        this.nc = nc;
        this.sid = sid;
    }

    public Student() {
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
