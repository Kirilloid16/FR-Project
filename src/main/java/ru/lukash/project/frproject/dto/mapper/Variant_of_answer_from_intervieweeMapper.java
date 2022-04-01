package ru.lukash.project.frproject.dto.mapper;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Service;
import ru.lukash.project.frproject.dto.Variant_of_answer_from_intervieweeDto;
import ru.lukash.project.frproject.model.Variant_of_answer_from_interviewee;

import java.util.List;

@Mapper(componentModel = "spring")
@Service
public interface Variant_of_answer_from_intervieweeMapper {
    Variant_of_answer_from_intervieweeDto variantToDto(Variant_of_answer_from_interviewee variant_of_answer_from_interviewee);
    List<Variant_of_answer_from_intervieweeDto> variantToDtoList(List<Variant_of_answer_from_interviewee> variantOfAnswerFromIntervieweeList);
}
