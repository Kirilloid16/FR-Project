package ru.lukash.project.frproject.dto;

import lombok.Data;
import ru.lukash.project.frproject.model.Question;

@Data
public class Variant_of_answer_from_intervieweeDto {
    private int id;
    private int interviewee_id;
    private Question question_id;
}
