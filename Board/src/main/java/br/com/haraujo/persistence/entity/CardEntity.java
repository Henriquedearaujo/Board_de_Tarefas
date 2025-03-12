package br.com.haraujo.persistence.entity;

import lombok.Data;

@Data
public class CardEntity {

    private Long id;
    private String title;
    private String description;
}
