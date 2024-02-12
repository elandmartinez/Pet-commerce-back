package competcommerce.persistence.repository.pagination;

import competcommerce.persistence.entity.Product;
import org.springframework.data.repository.ListPagingAndSortingRepository;

public interface ProductPagSortRepository extends ListPagingAndSortingRepository<Product, Integer> {
}
