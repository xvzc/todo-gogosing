package com.benchmark.mvc.controllers;

import com.benchmark.mvc.repository.UserRepository;
import com.benchmark.mvc.dataobject.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    private UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // home
    @GetMapping(path="/")
    public String mvcHome() {
        return "Welcome to benchmarking MVC!";
    }

    // GET /mvc/users
    @GetMapping(path="/users")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // POST /mvc/users
    @PostMapping(path="/users")
    public void addUser(@RequestBody User user) {
        userRepository.save(user);
    }

    // GET /mvc/users/{id}
    @GetMapping(path="/users/{id}")
    public Optional<User> getUser(@PathVariable int id) {
        return userRepository.findById(id);
    }

    // DELETE /mvc/users/{id}
    @DeleteMapping(path="/users/{id}")
    public void deleteUser(@PathVariable int id) {
        userRepository.deleteById(id);
    }
}