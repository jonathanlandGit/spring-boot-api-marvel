package com.jonathanland.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity
@Getter
@ToString
@NoArgsConstructor
public class MarvelHeroes {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    @NotEmpty
    private String name;
    @NotEmpty
    private String description;
    private int yearsOld;
    private int topComicBookPrice;

    public MarvelHeroes(String name, String description, int yearsOld, int topComicBookPrice) {
        this.name = name;
        this.description = description;
        this.yearsOld = yearsOld;
        this.topComicBookPrice = topComicBookPrice;
    }

}
