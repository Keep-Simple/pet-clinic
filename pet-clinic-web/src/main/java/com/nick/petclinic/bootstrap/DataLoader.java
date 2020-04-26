package com.nick.petclinic.bootstrap;

import com.nick.petclinic.model.Owner;
import com.nick.petclinic.model.Vet;
import com.nick.petclinic.services.OwnerService;
import com.nick.petclinic.services.VetService;
import com.nick.petclinic.services.map.OwnerServiceMap;
import com.nick.petclinic.services.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;


    public DataLoader() {
        ownerService = new OwnerServiceMap();
        vetService = new VetServiceMap();
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner = new Owner();
        owner.setId(1L);
        owner.setFirstName("Michael");
        owner.setLastName("Weston");
        ownerService.save(owner);

        owner = new Owner();
        owner.setId(2L);
        owner.setFirstName("Fiona");
        owner.setLastName("Gleanne");
        ownerService.save(owner);

        System.out.println("Loaded Owners...");

        Vet vet = new Vet();
        vet.setId(1L);
        vet.setFirstName("Sam");
        vet.setLastName("Axe");
        vetService.save(vet);

        vet = new Vet();
        vet.setId(2L);
        vet.setFirstName("Luis");
        vet.setLastName("Carrol");
        vetService.save(vet);

        System.out.println("Loaded Vets...");
    }
}
