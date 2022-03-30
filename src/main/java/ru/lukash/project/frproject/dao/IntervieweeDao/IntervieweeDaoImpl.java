package ru.lukash.project.frproject.dao.IntervieweeDao;

import org.springframework.stereotype.Repository;
import ru.lukash.project.frproject.model.Interviewee;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
@Repository
public class IntervieweeDaoImpl implements IntervieweeDao {
    private final EntityManager entityManager;

    public IntervieweeDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Interviewee> AllInterviewees() {
        TypedQuery<Interviewee> query = entityManager.createQuery("select I from Interviewee I",Interviewee.class);
        return query.getResultList();
    }

    @Override
    public void postInterviewee(Interviewee interviewee) {
        entityManager.persist(interviewee);
    }

    @Override
    public void updateInterviewee(Interviewee interviewee) {
        entityManager.merge(interviewee);
    }

    @Override
    public Interviewee getIntervieweeById(int id) {
        return entityManager.find(Interviewee.class,id);
    }

    @Override
    public void deleteIntervieweeById(int id) {
        TypedQuery<Interviewee> query = entityManager.createQuery("delete from Interviewee I where I.id=:id",Interviewee.class)
                .setParameter("id",id);
        query.executeUpdate();
    }
}
