package ru.lukash.project.frproject.service.IntervieweeService;

import ru.lukash.project.frproject.model.Interviewee;

import java.util.List;

public interface IntervieweeService {
    List<Interviewee> AllInterviewees();

    void postInterviewee(Interviewee interviewee);

    void updateInterviewee(Interviewee interviewee);

    Interviewee getIntervieweeById(int id);

    void deleteIntervieweeById(int id);
}
