package ru.lukash.project.frproject.service.Variant_of_answer_from_intervieweeService;

import org.springframework.stereotype.Service;
import ru.lukash.project.frproject.dao.Variant_of_answer_from_intervieweeDao.Variant_of_answer_from_intervieweeDao;
import ru.lukash.project.frproject.model.Variant_of_answer_from_interviewee;

import javax.transaction.Transactional;
import java.util.List;
@Service
public class Variant_of_answer_from_intervieweeServiceImpl implements Variant_of_answer_from_intervieweeService {
    private final Variant_of_answer_from_intervieweeDao variant_of_answer_from_intervieweeDao;

    public Variant_of_answer_from_intervieweeServiceImpl(Variant_of_answer_from_intervieweeDao variant_of_answer_from_intervieweeDao) {
        this.variant_of_answer_from_intervieweeDao = variant_of_answer_from_intervieweeDao;
    }

    @Override
    @Transactional
    public List<Variant_of_answer_from_interviewee> AllAnswers() {
        return variant_of_answer_from_intervieweeDao.AllAnswers();
    }

    @Override
    @Transactional
    public void postAnswer(Variant_of_answer_from_interviewee answer) {
            variant_of_answer_from_intervieweeDao.postAnswer(answer);
    }

    @Override
    @Transactional
    public void updateAnswer(Variant_of_answer_from_interviewee answer) {
        variant_of_answer_from_intervieweeDao.updateAnswer(answer);
    }

    @Override
    @Transactional
    public Variant_of_answer_from_interviewee getAnswerById(int id) {
        return variant_of_answer_from_intervieweeDao.getAnswerById(id);
    }

    @Override
    @Transactional
    public void deleteAnswerById(int id) {
        variant_of_answer_from_intervieweeDao.deleteAnswerById(id);
    }
}
