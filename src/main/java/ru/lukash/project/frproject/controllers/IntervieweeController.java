package ru.lukash.project.frproject.controllers;

import org.springframework.web.bind.annotation.*;
import ru.lukash.project.frproject.model.Interviewee;
import ru.lukash.project.frproject.model.Poll;
import ru.lukash.project.frproject.service.IntervieweeService.IntervieweeService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class IntervieweeController {
    private final IntervieweeService intervieweeService;

    public IntervieweeController(IntervieweeService intervieweeService) {
        this.intervieweeService = intervieweeService;
    }
    @GetMapping("/interviewees")
    public List<Interviewee> pollList (){
        return intervieweeService.AllInterviewees();
    }
    @GetMapping("/interviewee/{id}")
    public Interviewee interviewee (@PathVariable("id") int id){
        return intervieweeService.getIntervieweeById(id);
    }


    @PostMapping("/interviewee")
    public void postPoll(@RequestBody Interviewee interviewee){
        intervieweeService.postInterviewee(interviewee);
    }

    @PatchMapping("/interviewee")
    public void patchPoll(@RequestBody Interviewee interviewee){
        intervieweeService.updateInterviewee(interviewee);
    }

    @DeleteMapping("/interviewee/{id}")
    public void deletePoll(@PathVariable("id") int id){
        intervieweeService.deleteIntervieweeById(id);
    }
}
