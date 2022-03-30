package ru.lukash.project.frproject.dao.PollDao;

import org.springframework.stereotype.Repository;
import ru.lukash.project.frproject.dao.PollDao.PollDao;
import ru.lukash.project.frproject.model.Poll;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;
@Repository
public class PollDaoImpl implements PollDao {
    private final EntityManager entityManager;

    public PollDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Poll> getAllPolls() {
        TypedQuery<Poll> query = entityManager.createQuery("select P from Poll P",Poll.class);
        return query.getResultList();
    }

    @Override
    public Poll getPollById(int id) {
        return entityManager.find(Poll.class,id);
    }

    @Override
    public void postPoll(Poll poll) {
        entityManager.persist(poll);
    }

    @Override
    public void updatePoll(Poll poll) {
    entityManager.merge(poll);
    }

    @Override
    public void deletePollById(int id) {
        Query query = entityManager.createQuery("delete from Poll where id=:id").setParameter("id",id);
        query.executeUpdate();
    }
}
