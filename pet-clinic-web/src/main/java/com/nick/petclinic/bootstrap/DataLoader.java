package com.nick.petclinic.bootstrap;

import com.nick.petclinic.model.Owner;
import com.nick.petclinic.model.Pet;
import com.nick.petclinic.model.PetType;
import com.nick.petclinic.model.Vet;
import com.nick.petclinic.services.OwnerService;
import com.nick.petclinic.services.PetService;
import com.nick.petclinic.services.PetTypeService;
import com.nick.petclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final PetService petService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, PetService petService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

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
        vetService.save(vet);

        vet = new Vet();
        vet.setFirstName("Luis");
        vet.setLastName("Carrol");
        vetService.save(vet);

        System.out.println("Loaded Vets...");
    }
}
