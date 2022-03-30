package ru.lukash.project.frproject.dao.Answers_on_questionDao;

import org.springframework.stereotype.Repository;
import ru.lukash.project.frproject.dao.Answers_on_questionDao.Answers_on_questionDao;
import ru.lukash.project.frproject.model.Answers_on_question;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
@Repository
public class Answers_on_questionDaoImpl implements Answers_on_questionDao {
    private final EntityManager entityManager;

    public Answers_on_questionDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Answers_on_question> answersOnQuestionList(int question_id) {
        TypedQuery<Answers_on_question> query = entityManager.createQuery("select A from Answers_on_question A where A.question_id=:question_id"
        , Answers_on_question.class).setParameter("question_id",question_id);
        return query.getResultList();
    }




    @Override
    public Answers_on_question getAnswersOnQuestionById(int question_id, int id) {
        TypedQuery<Answers_on_question> query = entityManager.createQuery("select A from Answers_on_question A where A.id=:id and A.question_id=:question_id"
                , Answers_on_question.class).setParameter("question_id",question_id);
        return query.getSingleResult();
    }

    @Override
    public void postAnswersOnQuestion(Answers_on_question answers_on_question) {
        entityManager.persist(answers_on_question);
    }

    @Override
    public void updateAnswersOnQuestion(Answers_on_question answers_on_question) {
        entityManager.merge(answers_on_question);
    }

    @Override
    public void deleteAnswersOnQuestionById(int question_Id, int id) {
        TypedQuery<Answers_on_question> query= entityManager.createQuery("delete from Answers_on_question A where A.id=:id and A.question_id=:question_id"
                ,Answers_on_question.class).setParameter("id",id).setParameter("question_id",question_Id);
        query.executeUpdate();
    }
}
