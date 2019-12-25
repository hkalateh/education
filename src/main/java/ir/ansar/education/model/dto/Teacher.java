package ir.ansar.education.model.dto;

import java.io.Serializable;

public class Teacher extends Person implements Serializable {

    private Long tid;
    private Double salary;

    public Teacher(Long tid, Double salary) {
        this.tid = tid;
        this.salary = salary;
    }

    public Teacher(String uid, String username, String password, String name, String family, Long tid, Double salary) {
        super(uid, username, password, name, family);
        this.tid = tid;
        this.salary = salary;
    }

    public Teacher() {
    }

    public Long getTid() {
        return tid;
    }

    public void setTid(long tid) {
        this.tid = tid;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }
}
