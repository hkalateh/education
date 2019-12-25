package ir.ansar.education.model.repository;

import ir.ansar.education.model.dto.SignUp;
import ir.ansar.education.model.dto.Student;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class StudentRep {
    @PersistenceContext
    private EntityManager entityManager;

    public void registerStudent(Student student) {
        entityManager.persist(student);
    }

    public List<Student> getStudentList() {
        return entityManager.createQuery("select s from student s").getResultList();
    }

    public Student getStudentWithId(String iid) {
        return (Student) entityManager.createQuery("select s from student s where s.id=:id").setParameter("id", iid).getSingleResult();
    }

    public void deleteStudent(String sid) {
        entityManager.createQuery("delete from student s where s.sid=:sid")
                .setParameter("sid", sid)
                .executeUpdate();
    }

    public void updateStudent(Student student) {
        entityManager.createQuery("update student s set s.name=:name, s.family=:family, s.nc=:nc, s.username=:username, s.password=:password  where s.sid=:sid ")
                .setParameter("name", student.getName())
                .setParameter("family", student.getFamily())
                .setParameter("nc", student.getNc())
                .setParameter("sid", student.getSid())
                .setParameter("username", student.getUsername())
                .setParameter("password", student.getPassword())
                .executeUpdate();
    }


    public void updateStudentWithUP(Student student) {
        entityManager.createQuery("update student s set s.name=:name, s.family=:family, s.nc=:nc, s.sid=:sid  where s.username=:username and s.password=:password")
                .setParameter("name", student.getName())
                .setParameter("family", student.getFamily())
                .setParameter("nc", student.getNc())
                .setParameter("sid", student.getSid())
                .setParameter("username", student.getUsername())
                .setParameter("password", student.getPassword())
                .executeUpdate();
    }

    //todo is it true?
    public Student loginCheck(SignUp signUp){

        Student s= (Student) entityManager.createQuery("select p from student p where p.username=:username and p.password=:pass").setParameter("username", signUp.getUsername()).setParameter("pass", signUp.getPassword()).getSingleResult();
        if (s !=null){
            return s;
        }else {
            System.out.println("___!!!___student with this username password not found");
            return null;
        }
    }
}
