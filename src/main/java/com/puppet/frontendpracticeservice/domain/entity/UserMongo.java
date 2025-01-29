package com.puppet.frontendpracticeservice.domain.entity;

import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
@Document(collection = "users")
public class UserMongo {

    @Id
    private String id;
    private UUID userId;
    private List<AccountMongo> account;
}
