package competcommerce.persistence.repository;

import competcommerce.persistence.entity.PaymentMethod;
import org.springframework.data.repository.ListCrudRepository;

public interface PaymentMethodRepository extends ListCrudRepository<PaymentMethod, Integer> {
}
