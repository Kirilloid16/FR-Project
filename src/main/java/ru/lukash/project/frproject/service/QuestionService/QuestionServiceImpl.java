package ru.lukash.project.frproject.service.QuestionService;

import org.springframework.stereotype.Service;
import ru.lukash.project.frproject.dao.QuestionDao.QuestionDao;
import ru.lukash.project.frproject.model.Question;

import javax.transaction.Transactional;
import java.util.List;
@Service
public class QuestionServiceImpl implements QuestionService {
    private final QuestionDao questionDao;

    public QuestionServiceImpl(QuestionDao questionDao) {
        this.questionDao = questionDao;
    }

    @Override
    @Transactional
    public List<Question> questionList(int poll_id) {
        return questionDao.questionList(poll_id);
    }

    @Override
    @Transactional
    public Question getQuestionById(int poll_id, int id) {
        return questionDao.getQuestionById(poll_id,id);
    }

    @Override
    @Transactional
    public void postQuestion(Question question) {
        questionDao.postQuestion(question);
    }

    @Override
    @Transactional
    public void updateQuestion(Question question) {
        questionDao.updateQuestion(question);
    }

    @Override
    @Transactional
    public void deleteQuestion(int poll_id, int id) {
        questionDao.deleteQuestion(poll_id, id);
    }
}
