package com.puppet.frontendpracticeservice.domain.entity;

import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
@Getter
@Setter
@Builder
@Document(collection = "сards")
public class CardMongo {

    @Id
    private String id;
    private String number;
    private Date expirationDate;
    private Date issueDate;
    private TypeEnum type;
}
