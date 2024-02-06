package competcommerce.web.controller;


import competcommerce.persistence.entity.Pet;
import competcommerce.persistence.entityDataGenerators.PetDataGenerator;
import competcommerce.service.ClientService;
import competcommerce.service.PetService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/pets")
public class PetController {
    private final PetService petService;
    private final ClientService clientService;

    public PetController (PetService petService, ClientService clientService) {
        this.petService = petService;
        this.clientService = clientService;
    }

    @GetMapping("/get")
    public ResponseEntity getAll() {
        return ResponseEntity.ok(this.petService.getAll());
    }

    @GetMapping("/get/{petId}")
    public ResponseEntity getById(@PathVariable int petId) {
        return ResponseEntity.ok(this.petService.getById(petId));
    }

    @PostMapping("/post/{amountToGenerate}")
    public ResponseEntity post (@PathVariable int amountToGenerate) {
        int totalAmountOfClients = this.clientService.getAll().size();
        ArrayList<Pet> newPets = PetDataGenerator.generatePets(amountToGenerate, totalAmountOfClients);
        this.petService.addMany(newPets);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/post-pet")
    public ResponseEntity postOne(@RequestBody Pet newPet) {
        this.petService.addOne(newPet);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/update-pet")
    public ResponseEntity update (@RequestBody Pet updatePet) {
        this.petService.addOne(updatePet);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete/{petId}")
    public ResponseEntity delete(@PathVariable int petId) {
        this.petService.deleteById(petId);
        return ResponseEntity.ok().build();
    }
}
