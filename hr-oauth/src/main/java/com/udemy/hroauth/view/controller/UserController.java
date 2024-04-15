package com.udemy.hroauth.view.controller;

import com.udemy.hroauth.business.service.UserService;
import com.udemy.hroauth.model.entity.User;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {

    private UserService service;

    @GetMapping("/search")
    public ResponseEntity<User> getByEmail(@RequestParam String email) {
        return ResponseEntity.ok(service.getByEmail(email));
    }
}
