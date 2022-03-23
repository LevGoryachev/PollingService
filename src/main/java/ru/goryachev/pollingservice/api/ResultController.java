package ru.goryachev.pollingservice.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.goryachev.pollingservice.model.Result;
import ru.goryachev.pollingservice.model.dto.projection.ItemProjection;
import ru.goryachev.pollingservice.service.ResultService;

import java.util.List;

/**
 * API для сущности "Результат" (Result)
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
    public ResponseEntity<List<ItemProjection>> getAll (@RequestParam (value = "userid", required = false) Long userId) {
        return new ResponseEntity<>(resultService.getAllByUserId(userId), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Result> getById (@PathVariable Long id) {
            return new ResponseEntity<>(resultService.getById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Object> create (@RequestBody Result result) {
        return new ResponseEntity<>(resultService.save(result), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Object> update (@RequestBody Result modifiedResult) {
        return new ResponseEntity<>(resultService.save(modifiedResult), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Object> delete (@PathVariable Long id) {
        return new ResponseEntity<>(resultService.delete(id),HttpStatus.OK);
    }
}
