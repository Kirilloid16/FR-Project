package ru.lukash.project.frproject.controllers;

import org.springframework.web.bind.annotation.*;
import ru.lukash.project.frproject.dto.PollDto;
import ru.lukash.project.frproject.dto.mapper.PollMapper;
import ru.lukash.project.frproject.model.Poll;
import ru.lukash.project.frproject.service.PollService.PollService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class PollController {
    private final PollService pollService;
    private final PollMapper pollMapper;


    public PollController(PollService pollService, PollMapper pollMapper) {
        this.pollService = pollService;
        this.pollMapper = pollMapper;
    }

    @GetMapping("/polls")
    public List<PollDto> pollList (){
        return pollMapper.pollDtoList(pollService.getAllPolls());
    }

    @GetMapping("/polls/{id}")
    public PollDto getById(@PathVariable("id") int id){
      return pollMapper.pollToDto(pollService.getPollById(id));
    }

    @PostMapping("/poll")
    public void postPoll(@RequestBody Poll poll){
        pollService.postPoll(poll);
    }

    @PatchMapping("/poll")
    public void patchPoll(@RequestBody Poll poll){
        pollService.updatePoll(poll);
    }

    @DeleteMapping("/poll/{id}")
    public void deletePoll(@PathVariable("id")int id){
        pollService.deletePollById(id);
    }

}
