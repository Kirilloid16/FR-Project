package ru.lukash.project.frproject.dao.PollDao;

import ru.lukash.project.frproject.model.Poll;

import java.util.List;

public interface PollDao {
    List<Poll> getAllPolls();

    Poll getPollById(int id);

    void postPoll(Poll poll);

    void updatePoll(Poll poll);

    void deletePollById(int id);
}
