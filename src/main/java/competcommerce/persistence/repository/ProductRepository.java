package competcommerce.persistence.repository;

import competcommerce.persistence.entity.Product;
import org.springframework.data.repository.ListCrudRepository;

public interface ProductRepository extends ListCrudRepository<Product, Integer> {}
