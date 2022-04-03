package ru.goryachev.pollingservice.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.goryachev.pollingservice.model.Answer;
import ru.goryachev.pollingservice.service.AnswerService;

import java.util.List;

/**
 * API для сущности "Вопрос" (Answer)
 * Все исключения отлавливаются ru.goryachev.pollingservice.exception.ControllerAdvisor
 * @author Lev Goryachev
 * @version 1
 */

@Tag(name="XXX", description="YYYYY")
@RestController
@RequestMapping("/api/answers")
public class AnswerController {

    private AnswerService answerService;

    @Autowired
    public AnswerController(AnswerService answerService) {
        this.answerService = answerService;
    }

    @ApiOperation(
            value = "Get Answers of certain Question entity",
            notes = "Set the QuestionID in parameters")
    @GetMapping
    public ResponseEntity<List<Answer>> getAllByQuestionId (@RequestParam (value = "questionId", required = false) Long questionId) {
        return new ResponseEntity<>(answerService.getAllByQuestionId(questionId), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Answer> getById (@PathVariable Long id) {
            return new ResponseEntity<>(answerService.getById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Object> create (@RequestBody Answer answer) {
        return new ResponseEntity<>(answerService.save(answer), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Object> update (@RequestBody Answer modifiedAnswer) {
        return new ResponseEntity<>(answerService.save(modifiedAnswer), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Object> delete (@PathVariable Long id) {
        return new ResponseEntity<>(answerService.delete(id),HttpStatus.OK);
    }
}
