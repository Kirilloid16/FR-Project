package ru.lukash.project.frproject.model;

import javax.persistence.*;
import java.util.List;
@Entity
@Table(name = "variant_of_answer_from_interviewee ",schema = "public")
public class Variant_of_answer_from_interviewee {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "interviewee_id")
    private Long interviewee_id;
    @ManyToOne
    @JoinColumn(name = "poll_id")
    private Poll poll_id;
    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question_id;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "variant_of_answer_from_interviewee_answers_on_question"
    , joinColumns = @JoinColumn(name = "answer_id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "variant_of_answer_id"))
    public List<Answers_on_question> answers_on_questionList;

    public Variant_of_answer_from_interviewee() {
    }

    public Long getInterviewee_id() {
        return interviewee_id;
    }

    public void setInterviewee_id(Long interviewee_id) {
        this.interviewee_id = interviewee_id;
    }

    @Override
    public String toString() {
        return "Variant_of_answer_from_interviewee{" +
                "id=" + id +
                ", interviewee_id=" + interviewee_id +
                ", poll_id=" + poll_id +
                ", question_id=" + question_id +
                '}';
    }
}
