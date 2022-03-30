package ru.lukash.project.frproject.service.Answers_on_questionService;

import ru.lukash.project.frproject.model.Answers_on_question;

import java.util.List;

public interface Answers_on_questionService {
    List<Answers_on_question> answersOnQuestionList(int question_id);

    Answers_on_question getAnswersOnQuestionById(int question_id, int id);

    void postAnswersOnQuestion(Answers_on_question answers_on_question);

    void updateAnswersOnQuestion(Answers_on_question answers_on_question);

    void deleteAnswersOnQuestionById(int question_Id, int id);
}
