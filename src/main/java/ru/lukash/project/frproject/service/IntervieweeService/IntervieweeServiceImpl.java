package ru.lukash.project.frproject.service.IntervieweeService;

import org.springframework.stereotype.Service;
import ru.lukash.project.frproject.dao.IntervieweeDao.IntervieweeDao;
import ru.lukash.project.frproject.model.Interviewee;

import javax.transaction.Transactional;
import java.util.List;
@Service
public class IntervieweeServiceImpl implements IntervieweeService {

    private final IntervieweeDao intervieweeDao;

    public IntervieweeServiceImpl(IntervieweeDao intervieweeDao) {
        this.intervieweeDao = intervieweeDao;
    }

    @Override
    @Transactional
    public List<Interviewee> AllInterviewees() {
        return intervieweeDao.AllInterviewees();
    }

    @Override
    @Transactional
    public void postInterviewee(Interviewee interviewee) {
        intervieweeDao.postInterviewee(interviewee);
    }

    @Override
    @Transactional
    public void updateInterviewee(Interviewee interviewee) {
        intervieweeDao.updateInterviewee(interviewee);
    }

    @Override
    @Transactional
    public Interviewee getIntervieweeById(int id) {
        return intervieweeDao.getIntervieweeById(id);
    }

    @Override
    @Transactional
    public void deleteIntervieweeById(int id) {
        intervieweeDao.deleteIntervieweeById(id);
    }
}
