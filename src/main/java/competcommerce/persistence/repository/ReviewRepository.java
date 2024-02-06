package competcommerce.persistence.repository;

import competcommerce.persistence.entity.Review;
import org.springframework.data.repository.ListCrudRepository;

public interface ReviewRepository extends ListCrudRepository<Review, Integer> {
}
