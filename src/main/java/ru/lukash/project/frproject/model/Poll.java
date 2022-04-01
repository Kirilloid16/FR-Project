package ru.lukash.project.frproject.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

import javax.persistence.*;
import javax.validation.constraints.FutureOrPresent;


import java.time.LocalDate;

import java.util.List;

@Entity
@Table(name = "poll",schema = "public")
public class Poll {
    @Id
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "start_point", nullable = false)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy")
    @FutureOrPresent
    private LocalDate start_point;

    @Column(name = "end_point")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy")
    @FutureOrPresent
    private LocalDate end_point;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name ="poll_id")
    private List<Question> questions;

    public Poll() {
    }

    public Poll(String name, String description, LocalDate start_point, LocalDate end_point) {
        this.name = name;
        this.description = description;
        this.start_point = start_point;
        this.end_point = end_point;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getStart_point() {
        return start_point;
    }

    public void setStart_point(LocalDate start_point) {
        this.start_point = start_point;
    }

    public LocalDate getEnd_point() {
        return end_point;
    }

    public void setEnd_point(LocalDate end_point) {
        this.end_point = end_point;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    @Override
    public String toString() {
        return "Poll{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", start_point=" + start_point +
                ", end_point=" + end_point +
                ", questions=" + questions +
                '}';
    }
}


