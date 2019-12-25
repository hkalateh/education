package ir.ansar.education.model.repository;

import ir.ansar.education.model.dto.Lecture;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class LectureRep {
    @PersistenceContext
    private EntityManager entityManager;

    public void registerLecture(Lecture lecture){
        entityManager.persist(lecture);
    }

    public List<Lecture> getLectureList(){
        return entityManager.createQuery("select l from lecture l").getResultList();
    }

    public void deleteLecture(String lid){
        entityManager.createQuery("delete from lecture l where l.lid=:lid")
                .setParameter("lid",lid)
                .executeUpdate();
    }

    public Lecture getLectureWithId(String id){
        return (Lecture) entityManager.createQuery("select l from lecture l where l.lid=:id").setParameter("id",id).getSingleResult();
    }

    public void updateLecture(Lecture lecture){
        entityManager.createQuery("update lecture l set l.name=:name, l.unit=:unit, l.since=:f, l.until=:t where l.lid=:lid")
                .setParameter("name",lecture.getName())
                .setParameter("unit",lecture.getUnit())
                .setParameter("f",lecture.getSince())
                .setParameter("t",lecture.getUntil())
                .setParameter("lid",lecture.getLid())
                .executeUpdate();
    }
}
