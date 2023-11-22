package com.example.peliculas.dao;

import com.example.peliculas.entities.Gender;
import org.springframework.data.repository.CrudRepository;

public interface IGenderRepository extends CrudRepository<Gender, Long> {

}
