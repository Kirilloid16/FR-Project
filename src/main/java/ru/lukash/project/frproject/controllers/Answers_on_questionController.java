package ru.lukash.project.frproject.controllers;

import org.springframework.web.bind.annotation.*;
import ru.lukash.project.frproject.model.Answers_on_question;
import ru.lukash.project.frproject.model.Poll;
import ru.lukash.project.frproject.service.Answers_on_questionService.Answers_on_questionService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class Answers_on_questionController {
    private final Answers_on_questionService answers_on_questionService;

    public Answers_on_questionController(Answers_on_questionService answers_on_questionService) {
        this.answers_on_questionService = answers_on_questionService;
    }
    @GetMapping("/allAnswers/question/{question_id}")
    public List<Answers_on_question> answersOnQuestionList (@PathVariable("question_id") int question_id){
        return answers_on_questionService.answersOnQuestionList(question_id);
    }

    @GetMapping("/answerOnQuestion/question/{question_id}/answer/{id}")
    public Answers_on_question getAnswersOnQuestionById(@PathVariable("question_id") int question_id, @PathVariable("id") int id){
        return answers_on_questionService.getAnswersOnQuestionById(question_id, id);
    }

    @PostMapping("/answerOnQuestion")
    public void postAnswers_on_question(@RequestBody Answers_on_question answers_on_question){
        answers_on_questionService.postAnswersOnQuestion(answers_on_question);
    }

    @PatchMapping("/answerOnQuestion")
    public void patchAnswers_on_question(@RequestBody Answers_on_question answers_on_question){
        answers_on_questionService.updateAnswersOnQuestion(answers_on_question);
    }

    @DeleteMapping("/answerOnQuestion/question/{question_id}/answer/{id}")
    public void deleteAnswers_on_question(@PathVariable("question_id") int question_id,@PathVariable("id")int id){
        answers_on_questionService.deleteAnswersOnQuestionById(question_id, id);
    }

}
