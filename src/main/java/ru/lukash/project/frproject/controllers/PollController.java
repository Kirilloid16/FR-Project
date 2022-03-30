package ru.lukash.project.frproject.controllers;

import org.springframework.web.bind.annotation.*;
import ru.lukash.project.frproject.model.Poll;
import ru.lukash.project.frproject.service.PollService.PollService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PollController {
    private final PollService pollService;

    public PollController(PollService pollService) {
        this.pollService = pollService;
    }

    @GetMapping("/polls")
    public List<Poll> pollList (){
        return pollService.getAllPolls();
    }

    @GetMapping("/polls/{id}")
    public Poll getById(@PathVariable("id") int id){
      return pollService.getPollById(id);
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
