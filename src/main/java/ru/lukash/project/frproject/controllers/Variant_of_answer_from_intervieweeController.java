package ru.lukash.project.frproject.controllers;

import org.springframework.web.bind.annotation.*;
import ru.lukash.project.frproject.dto.Variant_of_answer_from_intervieweeDto;
import ru.lukash.project.frproject.dto.mapper.Variant_of_answer_from_intervieweeMapper;
import ru.lukash.project.frproject.model.Variant_of_answer_from_interviewee;
import ru.lukash.project.frproject.service.Variant_of_answer_from_intervieweeService.Variant_of_answer_from_intervieweeService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class Variant_of_answer_from_intervieweeController {
    private final Variant_of_answer_from_intervieweeService variant_of_answer_from_intervieweeService;
    private final Variant_of_answer_from_intervieweeMapper variant_of_answer_from_intervieweeMapper;

    public Variant_of_answer_from_intervieweeController(Variant_of_answer_from_intervieweeService variant_of_answer_from_intervieweeService, Variant_of_answer_from_intervieweeMapper variant_of_answer_from_intervieweeMapper) {
        this.variant_of_answer_from_intervieweeService = variant_of_answer_from_intervieweeService;
        this.variant_of_answer_from_intervieweeMapper = variant_of_answer_from_intervieweeMapper;
    }
    @GetMapping("/intervieweeAnswers")
    List<Variant_of_answer_from_intervieweeDto> AllAnswers(){
        return variant_of_answer_from_intervieweeMapper.variantToDtoList(variant_of_answer_from_intervieweeService.AllAnswers());
    };
    @PostMapping("/intervieweeAnswer")
    void postAnswer (@RequestBody Variant_of_answer_from_interviewee answer){
        variant_of_answer_from_intervieweeService.postAnswer(answer);
    };
    @PatchMapping("/intervieweeAnswer")
    void updateAnswer (@RequestBody Variant_of_answer_from_interviewee answer){
        variant_of_answer_from_intervieweeService.updateAnswer(answer);
    }
    @GetMapping("/intervieweeAnswer/{id}")
    Variant_of_answer_from_intervieweeDto getAnswerById (@PathVariable("id") int id){
        return variant_of_answer_from_intervieweeMapper.variantToDto(variant_of_answer_from_intervieweeService.getAnswerById(id));
    }
    @DeleteMapping("/intervieweeAnswer/{id}")
    void deleteAnswerById (@PathVariable("id")int id){
        variant_of_answer_from_intervieweeService.deleteAnswerById(id);
    }

}
