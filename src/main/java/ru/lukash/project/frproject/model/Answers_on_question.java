package ru.lukash.project.frproject.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "answers_on_question")
public class Answers_on_question {
    @Id
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "question_id")
    private int question_id;

    @Column(name = "description")
    private String description;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "variant_of_answer_from_interviewee_answers_on_question"
            , joinColumns = @JoinColumn(name = "variant_of_answer_id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "answer_id"))
    public List<Variant_of_answer_from_interviewee> variant_of_answer_from_intervieweeList;

    public Answers_on_question() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setQuestion_id(int question_id) {
        this.question_id = question_id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Answers_on_question{" +
                "id=" + id +
                ", question_id=" + question_id +
                ", description='" + description + '\'' +
                ", variant_of_answer_from_intervieweeList=" + variant_of_answer_from_intervieweeList +
                '}';
    }
}
