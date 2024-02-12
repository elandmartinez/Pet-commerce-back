package competcommerce.persistence.repository.pagination;

import competcommerce.persistence.entity.Review;
import org.springframework.data.repository.ListPagingAndSortingRepository;

public interface ReviewPagRepository extends ListPagingAndSortingRepository<Review, Integer> {
}
