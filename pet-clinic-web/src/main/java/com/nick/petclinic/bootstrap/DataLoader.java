package com.nick.petclinic.bootstrap;

import com.nick.petclinic.model.*;
import com.nick.petclinic.services.OwnerService;
import com.nick.petclinic.services.PetTypeService;
import com.nick.petclinic.services.SpecialtyService;
import com.nick.petclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtyService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialtyService specialtyService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
    }

    @Override
    public void run(String... args) throws Exception {

        if (petTypeService.findAll().size() == 0) loadData();
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Specialty radiology = new Specialty();
        radiology.setDescription("Radiology");
        Specialty saved = specialtyService.save(radiology);

        Specialty surgery = new Specialty();
        surgery.setDescription("Surgery");
        saved = specialtyService.save(surgery);

        Specialty dentistry = new Specialty();
        surgery.setDescription("Dentistry");
        saved = specialtyService.save(dentistry);

        Owner owner = new Owner();
        owner.setFirstName("Michael");
        owner.setLastName("Weston");
        owner.setAddress("123 Brickerel");
        owner.setCity("Miami");
        owner.setTelephone("0990063684");

        Pet pet = new Pet();
        pet.setPetType(savedDogPetType);
        pet.setOwner(owner);
        pet.setBirthDate(LocalDate.now());
        pet.setName("Rosco");

        owner.getPets().add(pet);
        ownerService.save(owner);

///////////////////////////////////////////////////////////////////////////

        owner = new Owner();
        owner.setFirstName("Fiona");
        owner.setLastName("Gleanne");
        owner.setAddress("123 Brickerel");
        owner.setCity("Miami");
        owner.setTelephone("0678843212");

        pet = new Pet();
        pet.setPetType(savedCatPetType);
        pet.setOwner(owner);
        pet.setBirthDate(LocalDate.now());
        pet.setName("Dastin");

        owner.getPets().add(pet);
        ownerService.save(owner);

        System.out.println("Loaded Owners...");

        Vet vet = new Vet();
        vet.setFirstName("Sam");
        vet.setLastName("Axe");
        vet.getSpecialties().add(radiology);
        vetService.save(vet);

        vet = new Vet();
        vet.setFirstName("Luis");
        vet.setLastName("Carrol");
        vet.getSpecialties().add(surgery);
        vetService.save(vet);

        System.out.println("Loaded Vets...");
    }
}
