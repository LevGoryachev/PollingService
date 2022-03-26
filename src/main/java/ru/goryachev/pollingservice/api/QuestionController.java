package ru.goryachev.pollingservice.api;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.goryachev.pollingservice.model.Question;
import ru.goryachev.pollingservice.service.QuestionService;

import java.util.List;

/**
 * API для сущности "Вопрос" (Question)
 * @author Lev Goryachev
 * @version 1
 */

@RestController
@RequestMapping("/api/questions")
public class QuestionController {

    private QuestionService questionService;

    @Autowired
    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @ApiOperation(
            value = "Получить вопросы определённого Опроса",
            notes = "В параметрах указать ID Опроса по которому выбираем и тип выбора ответа (выбор готового ответа или пользователь сам вносит текст ответа)")
    @GetMapping
    public ResponseEntity<List<Question>> getAllByPollId (@RequestParam (value = "poll", required = false) Long pollId, @RequestParam (value = "selector", required = false) Boolean isSelector) {
        return new ResponseEntity<>(questionService.getAllByPollId(pollId, isSelector), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Question> getById (@PathVariable Long id) {
            return new ResponseEntity<>(questionService.getById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Object> create (@RequestBody Question question) {
        return new ResponseEntity<>(questionService.save(question), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Object> update (@RequestBody Question modifiedQuestion) {
        return new ResponseEntity<>(questionService.save(modifiedQuestion), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Object> delete (@PathVariable Long id) {
        return new ResponseEntity<>(questionService.delete(id),HttpStatus.OK);
    }
}
