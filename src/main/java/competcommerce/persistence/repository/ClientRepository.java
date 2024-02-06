package competcommerce.persistence.repository;

import competcommerce.persistence.entity.Client;
import org.springframework.data.repository.ListCrudRepository;

public interface ClientRepository extends ListCrudRepository<Client, Integer> {}
