package competcommerce.persistence.repository;

import competcommerce.persistence.entity.Pet;
import org.springframework.data.repository.ListCrudRepository;

public interface PetRepository extends ListCrudRepository<Pet, Integer> {
}
