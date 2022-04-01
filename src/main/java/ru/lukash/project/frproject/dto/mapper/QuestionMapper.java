package ru.lukash.project.frproject.dto.mapper;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Service;
import ru.lukash.project.frproject.dto.QuestionDto;
import ru.lukash.project.frproject.model.Question;

import java.util.List;

@Mapper(componentModel = "spring")
@Service
public interface QuestionMapper {

    QuestionDto questionDto(Question question);
    List<QuestionDto> questionListToDtoList(List<Question> questionList);

}
