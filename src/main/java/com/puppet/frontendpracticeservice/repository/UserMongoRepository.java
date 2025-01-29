package com.puppet.frontendpracticeservice.repository;

import com.puppet.frontendpracticeservice.domain.entity.UserMongo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserMongoRepository extends MongoRepository<UserMongo, String> {
    UserMongo findByUserId(UUID userId);
}
