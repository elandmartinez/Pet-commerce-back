package competcommerce.persistence.repository;

import competcommerce.persistence.entity.Client;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface ClientRepository extends ListCrudRepository<Client, Integer> {
    List<Client> findAllByNameContainingIgnoreCase(String name);
}
