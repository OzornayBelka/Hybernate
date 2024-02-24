package com.example.hibernate.controller;

import com.example.hibernate.entity.Users;
import com.example.hibernate.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class UserController {
    private UserRepository repository;

    @GetMapping("/persons/by-city")
    public ResponseEntity<List<Users>> getByCity(@RequestParam String city) {
        return ResponseEntity.ok(repository.findByCityOfLiving(city));
    }

    @GetMapping("/persons/by-age")
    public ResponseEntity<List<Users>> getByAge(@RequestParam int age) {
        return ResponseEntity.ok(repository.findByAgeLessThanOrderByAge(age));
    }

    @GetMapping("/persons/by-name-surname")
    public ResponseEntity<Optional<Users>> getByNameAndSurname(@RequestParam String name, String surname) {
        return ResponseEntity.ok(repository.findByNameAndSurname(name, surname));
    }


}
