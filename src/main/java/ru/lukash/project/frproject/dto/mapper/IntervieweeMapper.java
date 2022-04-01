package ru.lukash.project.frproject.dto.mapper;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Service;
import ru.lukash.project.frproject.dto.IntervieweeDto;
import ru.lukash.project.frproject.model.Interviewee;

import java.util.List;

@Mapper(componentModel = "spring")
@Service
public interface IntervieweeMapper {
    IntervieweeDto intervieweeToDto(Interviewee interviewee);
    List<IntervieweeDto> intervieweeToDtoList(List<Interviewee> intervieweeList);
}
