package ir.ansar.education.model.repository;

import ir.ansar.education.model.dto.SignUp;
import ir.ansar.education.model.dto.Teacher;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class TeacherRep {
    @PersistenceContext
   private EntityManager entityManager;

    public void registerTeacher(Teacher teacher){
        entityManager.persist(teacher);
    }

    public List<Teacher> getTeacherList(){
        return (List<Teacher>) entityManager.createQuery("select p from teacher p").getResultList();
    }

    public Teacher getTeacherWithId(String iid){
        /*List teac= entityManager.createQuery("select t from teacher t where t.tid=:id").setParameter("id",iid).getResultList();
        System.out.println(teac.get(0));
        if (teac.isEmpty()){
            System.out.println("hichi mojood nist");
            return new Teacher("empty",0L);}
        else return (Teacher) teac.get(0);*/
        return (Teacher) entityManager.createQuery("select t from teacher t where t.tid=:id")
                .setParameter("id",iid)
                .getSingleResult();
    }

    public void deleteTeacher(String tid){
        entityManager.createQuery("delete from teacher t where t.tid=:tid")
                .setParameter("tid",tid)
                .executeUpdate();
    }

    public void updateTeacher(Teacher teacher){
        entityManager.createQuery("update teacher t set t.salary=:salary, t.name=:name, t.family=:family, t.username=:username, t.password=:password where t.tid=:tid")
                .setParameter("salary",teacher.getSalary())
                .setParameter("name",teacher.getName())
                .setParameter("family",teacher.getFamily())
                .setParameter("tid",teacher.getTid())
                .setParameter("username",teacher.getUsername())
                .setParameter("password", teacher.getPassword())
                .executeUpdate();
    }

    //todo is it true?
    public Teacher loginCheck(SignUp signUp){

        Teacher t= (Teacher) entityManager.createQuery("select p from student p where p.username=:username and p.password=:pass").setParameter("username", signUp.getUsername()).setParameter("pass", signUp.getPassword()).getSingleResult();
        if (t!=null){
            return t;
        }else {
            System.out.println("___!!!___teacher with this username password not found");
            return null;
        }
    }
}
