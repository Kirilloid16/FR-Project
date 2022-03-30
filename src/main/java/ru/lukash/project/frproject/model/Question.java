package ru.lukash.project.frproject.model;

import org.hibernate.metamodel.model.convert.internal.OrdinalEnumValueConverter;
import ru.lukash.project.frproject.Enum.Type_of_Question;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "question",schema = "public")
public class Question {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Enumerated(EnumType.ORDINAL)
    private Type_of_Question type_of_question;

    @Column(name = "poll_id")
    private Long poll_id;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "question_id")
    private List<Answers_on_question> answers;

    public Question() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Type_of_Question getType_of_question() {
        return type_of_question;
    }

    public void setType_of_question(Type_of_Question type_of_question) {
        this.type_of_question = type_of_question;
    }

    public Long getPoll_id() {
        return poll_id;
    }

    public void setPoll_id(Long poll_id) {
        this.poll_id = poll_id;
    }

    public List<Answers_on_question> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answers_on_question> answers) {
        this.answers = answers;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type_of_question=" + type_of_question +
                ", poll_id=" + poll_id +
                '}';
    }
}
