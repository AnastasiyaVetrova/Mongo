package com.puppet.frontendpracticeservice.service.impl;

import com.puppet.frontendpracticeservice.domain.entity.UserMongo;
import com.puppet.frontendpracticeservice.repository.UserMongoRepository;
import com.puppet.frontendpracticeservice.service.UserMongoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserMongoServiceImpl implements UserMongoService {

    private final UserMongoRepository userMongoRepository;

    @Override
    public void save(UserMongo user) {
        userMongoRepository.save(user);
    }

    @Override
    public UserMongo findByUserId(UUID userId) {
        return userMongoRepository.findByUserId(userId);
    }
}
