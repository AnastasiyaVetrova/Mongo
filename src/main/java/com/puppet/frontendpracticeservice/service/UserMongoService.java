package com.puppet.frontendpracticeservice.service;

import com.puppet.frontendpracticeservice.domain.entity.UserMongo;

import java.util.UUID;

public interface UserMongoService {

    void save(UserMongo user);

    UserMongo findByUserId(UUID userId);
}
