package ru.lukash.project.frproject.dao.QuestionDao;

import org.springframework.stereotype.Repository;
import ru.lukash.project.frproject.dao.QuestionDao.QuestionDao;
import ru.lukash.project.frproject.model.Question;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import java.util.List;
@Repository
public class QuestionDaoImpl implements QuestionDao {
    private final EntityManager entityManager;

    public QuestionDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Question> questionList(int poll_id) {
        Query query = entityManager.createQuery("select Q from Question Q where Q.poll_id=:poll_id").setParameter("poll_id",poll_id);
        return query.getResultList();
    }

    @Override
    public Question getQuestionById(int poll_id, int id) {
        TypedQuery<Question> query = entityManager.createQuery("select Q from Question Q where Q.poll_id=:poll_id and Q.id=:id",Question.class)
                .setParameter("poll_id",poll_id)
                .setParameter("id",id);
        return query.getSingleResult();
    }

    @Override
    public void postQuestion(Question question) {
        entityManager.persist(question);
    }

    @Override
    public void updateQuestion(Question question) {
        entityManager.merge(question);
    }

    @Override
    public void deleteQuestion(int poll_id, int id) {
        TypedQuery<Question> query = entityManager.createQuery("delete from Question Q where Q.poll_id=:poll_id and Q.id=:id",Question.class)
                .setParameter("poll_id",poll_id)
                .setParameter("id",id);
        query.executeUpdate();
    }
}
