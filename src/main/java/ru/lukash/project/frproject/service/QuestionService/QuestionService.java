package ru.lukash.project.frproject.service.QuestionService;

import ru.lukash.project.frproject.model.Question;

import java.util.List;

public interface QuestionService {
    List<Question> questionList(int poll_id);

    Question getQuestionById(int poll_id, int id);

    void postQuestion(Question question);

    void updateQuestion(Question question);

    void deleteQuestion(int poll_id, int id);

}
