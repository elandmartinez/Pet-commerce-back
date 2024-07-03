package competcommerce.persistence.repository;

import competcommerce.persistence.entity.Review;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface ReviewRepository extends ListCrudRepository<Review, Integer> {

    @Query("SELECT r FROM Review r WHERE r.productId = ?1")
    List<Review> findByReviewsByProductId (int productId);
}
