package ru.lukash.project.frproject.controllers;

import org.springframework.web.bind.annotation.*;
import ru.lukash.project.frproject.model.Variant_of_answer_from_interviewee;
import ru.lukash.project.frproject.service.Variant_of_answer_from_intervieweeService.Variant_of_answer_from_intervieweeService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class Variant_of_answer_from_intervieweeController {
    private final Variant_of_answer_from_intervieweeService variant_of_answer_from_intervieweeService;

    public Variant_of_answer_from_intervieweeController(Variant_of_answer_from_intervieweeService variant_of_answer_from_intervieweeService) {
        this.variant_of_answer_from_intervieweeService = variant_of_answer_from_intervieweeService;
    }
    @GetMapping("/intervieweeAnswers")
    List<Variant_of_answer_from_interviewee> AllAnswers(){
        return variant_of_answer_from_intervieweeService.AllAnswers();
    };
    @PostMapping("/intervieweeAnswer")
    void postAnswer (Variant_of_answer_from_interviewee answer){
        variant_of_answer_from_intervieweeService.postAnswer(answer);
    };
    @PatchMapping("/intervieweeAnswer")
    void updateAnswer (Variant_of_answer_from_interviewee answer){
        variant_of_answer_from_intervieweeService.updateAnswer(answer);
    }
    @GetMapping("/intervieweeAnswer/{id}")
    Variant_of_answer_from_interviewee getAnswerById (@PathVariable("id") int id){
        return variant_of_answer_from_intervieweeService.getAnswerById(id);
    }
    @DeleteMapping("/intervieweeAnswer/{id}")
    void deleteAnswerById (@PathVariable("id")int id){
        variant_of_answer_from_intervieweeService.deleteAnswerById(id);
    }

}
