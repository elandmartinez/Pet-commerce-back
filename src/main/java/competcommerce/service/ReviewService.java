package competcommerce.service;

import competcommerce.persistence.entity.Review;
import competcommerce.persistence.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {
    private final ReviewRepository reviewRepository;

    @Autowired
    public ReviewService (ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public List<Review> getAll () {
        return this.reviewRepository.findAll();
    }

    public List<Review> getByProductId (int productId) {return this.reviewRepository.findByReviewsByProductId(productId);}

    public Optional<Review> getById (int reviewId) {
        if(!this.reviewRepository.existsById(reviewId)) {
            throw new RuntimeException("There's no records for the id provided");
        }
        return this.reviewRepository.findById(reviewId);
    }

    public void addMany (List<Review> reviews) {
        this.reviewRepository.saveAll(reviews);
    }

    public void addOne(Review review) { this.reviewRepository.save(review);}

    public void deleteById (int reviewId) {
        this.reviewRepository.deleteById(reviewId);
    }
    //TODO: make all services methods that post return void
}
