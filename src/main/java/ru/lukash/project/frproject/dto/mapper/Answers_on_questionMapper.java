package ru.lukash.project.frproject.dto.mapper;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ru.lukash.project.frproject.dto.Answers_on_questionDto;
import ru.lukash.project.frproject.model.Answers_on_question;

import java.util.List;

@Mapper(componentModel = "spring")
@Service
public interface Answers_on_questionMapper {
    Answers_on_questionDto answerToDto (Answers_on_question answers_on_question);
    List<Answers_on_questionDto> answerToDtoList(List<Answers_on_question> answersOnQuestionList);
}
