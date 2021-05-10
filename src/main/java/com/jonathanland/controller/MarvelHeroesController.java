package com.jonathanland.controller;

import com.jonathanland.entity.MarvelHeroes;
import com.jonathanland.repository.MarvelHeroesRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RestController
public class MarvelHeroesController {

    private MarvelHeroesRepository marvelHeroesRepository;

    public MarvelHeroesController(MarvelHeroesRepository marvelHeroesRepository) {
        this.marvelHeroesRepository = marvelHeroesRepository;
    }

    @GetMapping(value = "/hero", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<MarvelHeroes> getHeroes() {
        return marvelHeroesRepository.findAll();
    }

    @GetMapping(value = "/hero/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public MarvelHeroes getHero(@PathVariable long id){
        return marvelHeroesRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Invalid hero id %s", id)));
    }

    @PostMapping(value = "/hero", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public MarvelHeroes createHero(@Valid @RequestBody MarvelHeroes marvelHeroes) {
        return marvelHeroesRepository.save(marvelHeroes);
    }
}
