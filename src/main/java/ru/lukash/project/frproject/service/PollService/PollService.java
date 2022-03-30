package ru.lukash.project.frproject.service.PollService;

import ru.lukash.project.frproject.model.Poll;

import java.util.List;

public interface PollService {
    List<Poll> getAllPolls();

    Poll getPollById(int id);

    void postPoll(Poll poll);

    void updatePoll(Poll poll);

    void deletePollById(int id);
}
