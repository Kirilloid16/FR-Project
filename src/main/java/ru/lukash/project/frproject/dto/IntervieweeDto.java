package ru.lukash.project.frproject.dto;

import lombok.Data;
import ru.lukash.project.frproject.model.Variant_of_answer_from_interviewee;

import java.util.List;
@Data
public class IntervieweeDto {
    private int id;
    private String user_name;
    private List<Variant_of_answer_from_interviewee> variant_of_answer_from_interviewees;
}
