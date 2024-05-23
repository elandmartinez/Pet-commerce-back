package competcommerce.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "reviews")
@Getter
@Setter
@NoArgsConstructor
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "review_id")
    private int reviewId;

    @Column(nullable = false)
    private short score;

    @Column(nullable = false, length = 400)
    private String description;

    @Column(nullable = false, name = "product_id")
    private int productId;

    public Review (
            short score,
            String description,
            int productId
    ) {
        this.score = score;
        this.description = description;
        this.productId = productId;
    }
}