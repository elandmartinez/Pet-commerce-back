package competcommerce.web.controller;

import competcommerce.persistence.entity.Review;
import competcommerce.persistence.entityDataGenerators.ReviewDataGenerator;
import competcommerce.service.ProductService;
import competcommerce.service.ReviewService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

    private final ReviewService reviewService;
    private final ProductService productService;

    public ReviewController (ReviewService reviewService, ProductService productService) {
        this.reviewService = reviewService;
        this.productService = productService;
    }

    @GetMapping("/get")
    public ResponseEntity getAll() {
        return ResponseEntity.ok(this.reviewService.getAll());
    }

    @GetMapping("/get/{reviewId}")
    public ResponseEntity getOne(@PathVariable int reviewId) {
        return ResponseEntity.ok(this.reviewService.getById(reviewId));
    }

    @PostMapping("/post/{amountToGenerate}")
    public ResponseEntity post(@PathVariable int amountToGenerate) {
        int totalAmountOfProducts = this.productService.getAll().size();
        ArrayList<Review> newReviews = ReviewDataGenerator.generateReviews(amountToGenerate, totalAmountOfProducts);
        this.reviewService.addMany(newReviews);

        return ResponseEntity.ok().build();
    }

    @PostMapping("/post-review")
    public ResponseEntity postOne (@RequestBody Review newReview) {
        this.reviewService.addOne(newReview);

        return ResponseEntity.ok().build();
    }

    @PutMapping("/update-review")
    public ResponseEntity update (@RequestBody Review newReview) {
        this.reviewService.addOne(newReview);

        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete/{reviewId}")
    public ResponseEntity delete (@PathVariable int reviewId) {
        this.reviewService.deleteById(reviewId);
        return ResponseEntity.ok().build();
    }
}
