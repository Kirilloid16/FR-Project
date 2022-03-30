package ru.lukash.project.frproject.controllers;

import org.springframework.web.bind.annotation.*;
import ru.lukash.project.frproject.model.Interviewee;
import ru.lukash.project.frproject.model.Question;
import ru.lukash.project.frproject.service.QuestionService.QuestionService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class QuestionController {
    private final QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }
    @GetMapping("poll/questions/{poll_id}")
    List<Question> questionList(@PathVariable("poll_id") int poll_id){
        return questionService.questionList(poll_id);
    }
    @GetMapping("poll/{poll_id}/question/{id}")
    Question getQuestionById(@PathVariable("poll_id") int poll_id,@PathVariable("id") int id){
        return questionService.getQuestionById(poll_id, id);
    }
    @PostMapping("question")
    void postQuestion(Question question){
        questionService.postQuestion(question);
    }
    @PatchMapping("/question")
    void updateQuestion(Question question){
        questionService.updateQuestion(question);
    };
    @DeleteMapping("/poll/{poll_id}/question/{id}")
    void deleteQuestion(@PathVariable("poll_id") int poll_id,@PathVariable("id") int id){
        questionService.deleteQuestion(poll_id, id);
    }
}
