package ru.lukash.project.frproject.controllers;

import org.springframework.web.bind.annotation.*;
import ru.lukash.project.frproject.dto.QuestionDto;
import ru.lukash.project.frproject.dto.mapper.QuestionMapper;
import ru.lukash.project.frproject.model.Question;
import ru.lukash.project.frproject.service.QuestionService.QuestionService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class QuestionController {
    private final QuestionService questionService;
    private final QuestionMapper questionMapper;

    public QuestionController(QuestionService questionService, QuestionMapper questionMapper) {
        this.questionService = questionService;
        this.questionMapper = questionMapper;
    }
    @GetMapping("poll/questions/{poll_id}")
    List<QuestionDto> questionList(@PathVariable("poll_id") int poll_id){
        return questionMapper.questionListToDtoList(questionService.questionList(poll_id));
    }
    @GetMapping("poll/{poll_id}/question/{id}")
    QuestionDto getQuestionById(@PathVariable("poll_id") int poll_id,@PathVariable("id") int id){
        return questionMapper.questionDto(questionService.getQuestionById(poll_id, id));
    }
    @PostMapping("question")
    void postQuestion(@RequestBody Question question){
        questionService.postQuestion(question);
    }
    @PatchMapping("/question")
    void updateQuestion(@RequestBody Question question){
        questionService.updateQuestion(question);
    };
    @DeleteMapping("/poll/{poll_id}/question/{id}")
    void deleteQuestion(@PathVariable("poll_id") int poll_id,@PathVariable("id") int id){
        questionService.deleteQuestion(poll_id, id);
    }
}
