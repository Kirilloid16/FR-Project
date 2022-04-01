package ru.lukash.project.frproject.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;
import ru.lukash.project.frproject.dto.PollDto;
import ru.lukash.project.frproject.model.Poll;

import java.util.List;

@Mapper(componentModel = "spring")
@Service
public interface PollMapper {
    PollDto pollToDto(Poll poll);
    List<PollDto> pollDtoList (List<Poll> pollList);
}
