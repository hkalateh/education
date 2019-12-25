package ir.ansar.education.model.dto;

public class Person {
    private String uid;
    private String username;
    private String password;
    private String name;
    private String family;
    private boolean first=true;


    public Person() {
    }

    public Person(String uid, String username, String password, String name, String family) {
        this.uid = uid;
        this.username = username;
        this.password = password;
        this.name = name;
        this.family = family;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
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

    public boolean isFirst() {
        return first;
    }

    public void setFirst(boolean first) {
        this.first = first;
    }
}
