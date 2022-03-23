package ru.goryachev.pollingservice.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.goryachev.pollingservice.model.AppUser;
import ru.goryachev.pollingservice.service.AppUserService;

import java.util.List;

/**
 * API для сущности "Пользователь" (AppUser)
 * @author Lev Goryachev
 * @version 1
 */

@RestController
@RequestMapping("/api/users")
public class AppUserController {

    private AppUserService appUserService;

    @Autowired
    public AppUserController(AppUserService appUserService) {
        this.appUserService = appUserService;
    }

    @GetMapping
    public ResponseEntity<List<AppUser>> getAll() {
        return new ResponseEntity<>(appUserService.getAll(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<AppUser> getById (@PathVariable Long id) {
            return new ResponseEntity<>(appUserService.getById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Object> create (@RequestBody AppUser appUser) {
        return new ResponseEntity<>(appUserService.save(appUser), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Object> update (@RequestBody AppUser modifiedAppUser) {
        return new ResponseEntity<>(appUserService.save(modifiedAppUser), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Object> delete (@PathVariable Long id) {
        return new ResponseEntity<>(appUserService.delete(id),HttpStatus.OK);
    }
}
