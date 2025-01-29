package com.puppet.frontendpracticeservice.domain.entity;

import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Builder
@Document(collection = "Accounts")
public class AccountMongo {

    @Id
    private String id;
    private String number;
    private Integer balance;
    private Date openDate;
    private List<CardMongo> cards;

}
