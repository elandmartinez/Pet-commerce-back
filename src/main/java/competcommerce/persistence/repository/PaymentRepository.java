package competcommerce.persistence.repository;

import competcommerce.persistence.entity.Payment;
import org.springframework.data.repository.ListCrudRepository;

public interface PaymentRepository extends ListCrudRepository<Payment, Integer> {
}
