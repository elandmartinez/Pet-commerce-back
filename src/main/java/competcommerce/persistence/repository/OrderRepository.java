package competcommerce.persistence.repository;

import competcommerce.persistence.entity.Order;
import org.springframework.data.repository.ListCrudRepository;

public interface OrderRepository extends ListCrudRepository<Order, Integer> {
}
