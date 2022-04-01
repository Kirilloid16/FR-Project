package ru.lukash.project.frproject.controllers;

import org.springframework.web.bind.annotation.*;
import ru.lukash.project.frproject.dto.IntervieweeDto;
import ru.lukash.project.frproject.dto.mapper.IntervieweeMapper;
import ru.lukash.project.frproject.model.Interviewee;
import ru.lukash.project.frproject.service.IntervieweeService.IntervieweeService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class IntervieweeController {
    private final IntervieweeService intervieweeService;
    private final IntervieweeMapper intervieweeMapper;

    public IntervieweeController(IntervieweeService intervieweeService, IntervieweeMapper intervieweeMapper) {
        this.intervieweeService = intervieweeService;
        this.intervieweeMapper = intervieweeMapper;
    }
    @GetMapping("/interviewees")
    public List<IntervieweeDto> pollList (){
        return intervieweeMapper.intervieweeToDtoList(intervieweeService.AllInterviewees());
    }
    @GetMapping("/interviewee/{id}")
    public IntervieweeDto interviewee (@PathVariable("id") int id){
        return intervieweeMapper.intervieweeToDto(intervieweeService.getIntervieweeById(id));
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
