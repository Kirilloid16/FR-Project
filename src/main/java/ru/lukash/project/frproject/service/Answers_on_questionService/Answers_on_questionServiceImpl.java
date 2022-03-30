package ru.lukash.project.frproject.service.Answers_on_questionService;

import org.springframework.stereotype.Service;
import ru.lukash.project.frproject.dao.Answers_on_questionDao.Answers_on_questionDao;
import ru.lukash.project.frproject.model.Answers_on_question;

import javax.transaction.Transactional;
import java.util.List;
@Service
public class Answers_on_questionServiceImpl implements Answers_on_questionService {
    private final Answers_on_questionDao answers_on_questionDao;

    public Answers_on_questionServiceImpl(Answers_on_questionDao answers_on_questionDao) {
        this.answers_on_questionDao = answers_on_questionDao;
    }

    @Override
    @Transactional
    public List<Answers_on_question> answersOnQuestionList(int question_id) {
        return answers_on_questionDao.answersOnQuestionList(question_id);
    }

    @Override
    @Transactional
    public Answers_on_question getAnswersOnQuestionById(int question_id, int id) {
        return answers_on_questionDao.getAnswersOnQuestionById(question_id, id);
    }

    @Override
    @Transactional
    public void postAnswersOnQuestion(Answers_on_question answers_on_question) {
        answers_on_questionDao.postAnswersOnQuestion(answers_on_question);
    }

    @Override
    @Transactional
    public void updateAnswersOnQuestion(Answers_on_question answers_on_question) {
        answers_on_questionDao.updateAnswersOnQuestion(answers_on_question);
    }

    @Override
    @Transactional
    public void deleteAnswersOnQuestionById(int question_Id, int id) {
        answers_on_questionDao.deleteAnswersOnQuestionById(question_Id, id);
    }
}
