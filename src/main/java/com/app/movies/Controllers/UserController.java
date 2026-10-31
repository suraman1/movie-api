package com.app.movies.Controllers;

import com.app.movies.DTO.UserRequest;
import com.app.movies.Models.User;
import com.app.movies.Services.UserService;
import jakarta.validation.Valid;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<Optional<User>> getUser(@RequestParam ObjectId id) {
        return new ResponseEntity<Optional<User>>(userService.getUser(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        return new ResponseEntity<List<User>>(userService.getAllUsers(), HttpStatus.OK);
    }

    @PostMapping
    public  ResponseEntity<User> createUser(@Valid @RequestBody UserRequest userBody) {
        return new ResponseEntity<User>(userService.createUser(userBody), HttpStatus.CREATED);
    }
}
