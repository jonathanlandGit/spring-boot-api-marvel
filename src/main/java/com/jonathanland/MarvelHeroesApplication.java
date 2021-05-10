package com.jonathanland;

import com.jonathanland.entity.MarvelHeroes;
import com.jonathanland.repository.MarvelHeroesRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MarvelHeroesApplication  {
    public static void main(String[] args) {
        SpringApplication.run(MarvelHeroesApplication.class);
    }

    @Bean
    public CommandLineRunner sampleData(MarvelHeroesRepository repository) {
        return (args) -> {
            repository.save(new MarvelHeroes("Spiderman", "Guy who got bit by spider who is now ninja like.", 34, 100000));
            repository.save(new MarvelHeroes("Iron Man", "Billionarie, who devbeloped concern for others and has cool gear.", 55, 1000000));
            repository.save(new MarvelHeroes("Dr. Strange", "modernist doctor turned mysic.", 13, 1000000));
        };
    }
}
