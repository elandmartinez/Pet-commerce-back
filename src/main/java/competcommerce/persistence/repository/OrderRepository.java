package competcommerce.persistence.repository;

import competcommerce.persistence.entity.Client;
import competcommerce.persistence.entity.Order;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface OrderRepository extends ListCrudRepository<Order, Integer> {

    @Query("SELECT o FROM Order o WHERE o.clientId = ?1")
    public List<Client> getOrdersByClientId(String clientId);
}
