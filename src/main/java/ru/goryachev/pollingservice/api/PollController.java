package ru.goryachev.pollingservice.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.goryachev.pollingservice.model.Poll;
import ru.goryachev.pollingservice.service.PollService;

import java.util.List;

/**
 * CRUD для сущности "Опрос" (Poll)
 * @author Lev Goryachev
 * @version 1
 */

@Api(value="PollController", description="CRUD для сущности Опрос (Poll)")
@RestController
@RequestMapping("/api/polls")
public class PollController {

    private PollService pollService;

    @Autowired
    public PollController(PollService pollService) {
        this.pollService = pollService;
    }

    @GetMapping
    public ResponseEntity<List<Poll>> getAll () {
        return new ResponseEntity<>(pollService.getAll(), HttpStatus.OK);
    }

    @ApiOperation(value = "Получить активные опросы", notes = "Получить активные на данный момент опросы")
    @GetMapping("/active")
    public ResponseEntity<List<Poll>> getAllActive () {
        return new ResponseEntity<>(pollService.getAllActive(), HttpStatus.OK);
    }

    //
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Poll>> getAllByUser (@PathVariable Long id) {
        return new ResponseEntity<>(pollService.getAll(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Poll> getById (@PathVariable Long id) {
            return new ResponseEntity<>(pollService.getById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Object> create (@RequestBody Poll poll) {
        return new ResponseEntity<>(pollService.save(poll), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Object> update (@RequestBody Poll modifiedPoll) {
        return new ResponseEntity<>(pollService.save(modifiedPoll), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Object> delete (@PathVariable Long id) {
        return new ResponseEntity<>(pollService.delete(id),HttpStatus.OK);
    }
}
