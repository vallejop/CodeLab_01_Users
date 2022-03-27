package com.adaschool.users.controller;

import com.adaschool.users.data.User;
import com.adaschool.users.dto.UserDtoRequest;
import com.adaschool.users.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping( "/v1/user" )
public class UserController {

    private final IUserService userService;

    public UserController(@Autowired IUserService userService){
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<User>> getAll(){
        System.out.println("UserController - getAll() ");
        return new ResponseEntity<>(userService.all(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<User>> findById(@PathVariable String id){
        System.out.println("UserController - findById(id) ");
        return new ResponseEntity<>(userService.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody UserDtoRequest user){
        System.out.println("UserController - createUser(user)");
        return new ResponseEntity<>(userService.create(user), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> update(@RequestBody UserDtoRequest user, @PathVariable String id){
        System.out.println("UserController - update(user, id) ");
        return new ResponseEntity<>(userService.update(user, id), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<User> delete(@PathVariable String id){
        System.out.println("UserController - delete(id) ");
        return new ResponseEntity<>(userService.deleteById(id), HttpStatus.OK);
    }
}
