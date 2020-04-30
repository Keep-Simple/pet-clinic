package com.nick.petclinic.services.springdatajpa;

import com.nick.petclinic.model.Pet;
import com.nick.petclinic.repositories.PetRepository;
import com.nick.petclinic.services.PetService;

import java.util.HashSet;
import java.util.Set;

public class PetSDService implements PetService {

    private final PetRepository petRepository;

    public PetSDService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    @Override
    public Set<Pet> findAll() {
        Set<Pet> pets = new HashSet<>();
        petRepository.findAll().forEach(pets::add);
        return pets;
    }

    @Override
    public Pet findById(Long aLong) {
        return petRepository.findById(aLong).orElse(null);
    }

    @Override
    public Pet save(Pet object) {
        return petRepository.save(object);
    }

    @Override
    public void delete(Pet object) {
        petRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        petRepository.deleteById(aLong);
    }
}