package ru.goryachev.pollingservice.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.goryachev.pollingservice.model.SpResult;
import ru.goryachev.pollingservice.service.ResultService;

import java.util.*;

/**
 * API для сущности "Результат" (SpResult)
 * Все исключения отлавливаются ru.goryachev.pollingservice.exception.ControllerAdvisor
 * @author Lev Goryachev
 * @version 1
 */

@RestController
@RequestMapping("/api/results")
public class ResultController {

    private ResultService resultService;

    @Autowired
    public ResultController(ResultService resultService) {
        this.resultService = resultService;
    }

    @GetMapping
    public ResponseEntity<List<Object>> findAll (@RequestParam (value = "user", required = false) Long userId,
                                                         @RequestParam (value = "question", required = false) Long questionId,
                                                         @RequestParam (value = "poll", required = false) Long pollId) {
        Map<String, Long> params = new HashMap<>();
        params.put("userId", userId); //для выборки по ID пользователя
        params.put("questionId", questionId); //для выборки по ID вопроса
        params.put("pollId", pollId); //для выборки по ID опроса, голосования
        return new ResponseEntity<>(resultService.getAll(params), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Object> create (@RequestBody SpResult spResult) {
        return new ResponseEntity<>(resultService.save(spResult), HttpStatus.CREATED);
    }
}
