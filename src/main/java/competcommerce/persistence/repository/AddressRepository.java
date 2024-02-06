package competcommerce.persistence.repository;

import competcommerce.persistence.entity.Address;
import org.springframework.data.repository.ListCrudRepository;

public interface AddressRepository extends ListCrudRepository<Address, Integer> {
}
