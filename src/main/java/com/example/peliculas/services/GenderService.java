package com.example.peliculas.services;

import com.example.peliculas.dao.IGenderRepository;
import com.example.peliculas.entities.Gender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenderService implements IGenderService {
    @Autowired
    private IGenderRepository genderRepository;

    @Override
    public void save(Gender gender) {
        genderRepository.save(gender);
    }

    @Override
    public Gender findById(Long id) {
        return genderRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {
        genderRepository.deleteById(id);
    }

    @Override
    public List<Gender> findAll() {
        return (List<Gender>) genderRepository.findAll();
    }
}
