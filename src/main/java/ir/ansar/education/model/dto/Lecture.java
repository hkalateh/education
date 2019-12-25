package ir.ansar.education.model.dto;

import java.io.Serializable;
import java.util.Date;

public class Lecture implements Serializable {

    private String name;
    private long lid;
    private Integer unit;
    private Date since;
    private Date until;

    public Lecture() {
    }

    public Lecture(String name, long lid, Integer unit, Date since, Date until) {
        this.name = name;
        this.lid = lid;
        this.unit = unit;
        this.since = since;
        this.until = until;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getLid() {
        return lid;
    }

    public void setLid(long lid) {
        this.lid = lid;
    }

    public Integer getUnit() {
        return unit;
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
}
