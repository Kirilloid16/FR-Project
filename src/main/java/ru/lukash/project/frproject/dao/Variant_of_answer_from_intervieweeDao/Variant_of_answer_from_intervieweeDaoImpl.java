package ru.lukash.project.frproject.dao.Variant_of_answer_from_intervieweeDao;

import org.springframework.stereotype.Repository;
import ru.lukash.project.frproject.model.Variant_of_answer_from_interviewee;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class Variant_of_answer_from_intervieweeDaoImpl implements Variant_of_answer_from_intervieweeDao {
    private final EntityManager entityManager;

    public Variant_of_answer_from_intervieweeDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Variant_of_answer_from_interviewee> AllAnswers() {
        TypedQuery<Variant_of_answer_from_interviewee> query = entityManager.createQuery("SELECT V from Variant_of_answer_from_interviewee V"
                ,Variant_of_answer_from_interviewee.class);
        return query.getResultList();
    }

    @Override
    public void postAnswer(Variant_of_answer_from_interviewee answer) {
        entityManager.persist(answer);
    }

    @Override
    public void updateAnswer(Variant_of_answer_from_interviewee answer) {
        entityManager.merge(answer);
    }

    @Override
    public Variant_of_answer_from_interviewee getAnswerById(int id) {
        return entityManager.find(Variant_of_answer_from_interviewee.class,id);
    }

    @Override
    public void deleteAnswerById(int id) {
        TypedQuery<Variant_of_answer_from_interviewee> query = entityManager.createQuery("delete from Variant_of_answer_from_interviewee V where V.id=:id"
                        ,Variant_of_answer_from_interviewee.class)
                .setParameter("id",id);
        query.executeUpdate();
    }
}
