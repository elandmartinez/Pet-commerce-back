package competcommerce.persistence.entity;

import com.github.javafaker.DateAndTime;
import com.github.javafaker.Lorem;
import com.github.javafaker.Name;
import com.github.javafaker.Number;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

@Entity
@Table(name = "products")
@Getter
@Setter
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "product_id")
    private int productId;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false, length = 400)
    private String description;

    @Column(nullable = false, columnDefinition = "Decimal(11, 2)")
    private float price;

    @Column(nullable = false, length = 80)
    private String dimensions;

    @Column(nullable = false, name = "expiration_date")
    private String expirationDate;

    @Column(nullable = false, name = "elaboration_date")
    private String elaborationDate;

    @Column(nullable = false, length = 50)
    private String provider;

    @Column(nullable = false, length = 50)
    private String category;

    @Column(nullable = false)
    private int stock;

    @Column(nullable = false, length = 150, name = "image_url")
    private String imageUrl;


    public Product (
            String name,
            String description,
            int price,
            String dimensions,
            String expirationDate,
            String elaborationDate,
            String provider,
            String category,
            int stock,
            String imageUrl
            ) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
        this.dimensions = dimensions;
        this.expirationDate = expirationDate;
        this.elaborationDate = elaborationDate;
        this.provider = provider;
        this.stock = stock;
        this.imageUrl = imageUrl;
    }
}
