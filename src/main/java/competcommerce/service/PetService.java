package competcommerce.service;

import competcommerce.persistence.entity.Pet;
import competcommerce.persistence.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PetService {
    private final PetRepository petRepository;

    @Autowired
    public PetService (PetRepository petRepository) { this.petRepository = petRepository;}


    public List<Pet> getAll () { return this.petRepository.findAll();}

    public Optional<Pet> getById (int petId) {
        if(!this.petRepository.existsById(petId)) {
            throw new RuntimeException("There's no records for the id provided");
        }
        return this.petRepository.findById(petId);
    }

    public void addMany (List<Pet> pets) { this.petRepository.saveAll(pets);}

    public void addOne (Pet newPet) { this.petRepository.save(newPet);}

    public void deleteById (int petId) { this.petRepository.deleteById(petId);}
}
