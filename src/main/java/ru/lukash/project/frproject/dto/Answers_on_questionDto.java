package ru.lukash.project.frproject.dto;

import lombok.Data;
import ru.lukash.project.frproject.model.Question;

@Data
public class Answers_on_questionDto {
    private int id;
    private int question_id;
    private String description;
}
