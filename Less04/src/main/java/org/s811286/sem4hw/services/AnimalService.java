package org.s811286.sem4hw.services;

import org.s811286.sem4hw.model.Animal;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AnimalService {

    private List<Animal> animals = new ArrayList<>();

    public void addAnimal(Animal p) {
        animals.add(p);
    }

    public List<Animal> findAll() {
        return animals;
    }
}
