package ru.lukash.project.frproject.dto;

import lombok.Data;
import ru.lukash.project.frproject.Enum.Type_of_Question;

@Data
public class QuestionDto {
    private int id;
    private String name;
    private Type_of_Question type_of_question;
    private int poll_id;
}
