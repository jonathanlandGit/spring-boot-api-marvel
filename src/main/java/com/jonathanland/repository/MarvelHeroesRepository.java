package com.jonathanland.repository;

import com.jonathanland.entity.MarvelHeroes;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MarvelHeroesRepository extends CrudRepository<MarvelHeroes, Long> {
    List<MarvelHeroes> findByName(String name);
}