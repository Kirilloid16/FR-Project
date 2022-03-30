package ru.lukash.project.frproject.dao.Variant_of_answer_from_intervieweeDao;

import ru.lukash.project.frproject.model.Variant_of_answer_from_interviewee;

import java.util.List;

public interface Variant_of_answer_from_intervieweeDao {

    List<Variant_of_answer_from_interviewee> AllAnswers();

    void postAnswer (Variant_of_answer_from_interviewee answer);

    void updateAnswer (Variant_of_answer_from_interviewee answer);

    Variant_of_answer_from_interviewee getAnswerById (int id);

    void deleteAnswerById (int id);
}
