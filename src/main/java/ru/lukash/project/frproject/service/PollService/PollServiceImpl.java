package ru.lukash.project.frproject.service.PollService;

import org.springframework.stereotype.Service;
import ru.lukash.project.frproject.dao.PollDao.PollDao;
import ru.lukash.project.frproject.model.Poll;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class PollServiceImpl implements PollService {
    private final PollDao pollDao;

    public PollServiceImpl(PollDao pollDao) {
        this.pollDao = pollDao;
    }

    @Override
    @Transactional
    public List<Poll> getAllPolls() {
        return pollDao.getAllPolls();
    }

    @Override
    @Transactional
    public Poll getPollById(int id) {
        return pollDao.getPollById(id);
    }

    @Override
    @Transactional
    public void postPoll(Poll poll) {
        pollDao.postPoll(poll);
    }

    @Override
    @Transactional
    public void updatePoll(Poll poll) {
        pollDao.updatePoll(poll);
    }

    @Override
    @Transactional
    public void deletePollById(int id) {
        pollDao.deletePollById(id);
    }
}
