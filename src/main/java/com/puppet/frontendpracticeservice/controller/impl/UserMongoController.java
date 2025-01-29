package com.puppet.frontendpracticeservice.controller.impl;

import com.puppet.frontendpracticeservice.domain.entity.UserMongo;
import com.puppet.frontendpracticeservice.service.UserMongoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/frontend-practice/mongo")
@RequiredArgsConstructor
public class UserMongoController {
    private final UserMongoService userMongoService;

    @PostMapping
    @RequestMapping("/save")
    public void save(@RequestBody UserMongo user) {
        userMongoService.save(user);
    }

    @GetMapping
    @RequestMapping("/{userId}")
    public UserMongo findByUserId(@PathVariable UUID userId) {
        return userMongoService.findByUserId(userId);
    }
}
