package competcommerce.persistence.repository;

import competcommerce.persistence.entity.Address;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface AddressRepository extends ListCrudRepository<Address, Integer> {
    @Query("SELECT a FROM Address a WHERE a.clientId = ?1")
    public List<Address> getAddressesByClientId(String clientId);
}
