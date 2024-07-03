package competcommerce.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
@Getter
@Setter
@NoArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id", nullable = false)
    private int OrderId;

    @Column(nullable = false, name = "purchase_date")
    private String purchaseDate;

    @Column(nullable = false, length = 20)
    private String status;

    @Column(nullable = false, name = "card-last-four-numbers")
    private String cardLastFourNumbers;

    @Column(nullable = false, name = "card_owner_name")
    private String cardOwnerName;

    @Column(nullable = false, name = "client_id")
    private String clientId;

    @Column(nullable = false, name = "products_ids")
    private List<Integer> productsIds;

    public Order(
            String purchaseDate,
            String status,
            String cardLastFourNumbers,
            String cardOwnerName,
            String clientId,
            List<Integer> productsIds
    ) {
        this.purchaseDate = purchaseDate;
        this.status = status;
        this.cardLastFourNumbers = cardLastFourNumbers;
        this.cardOwnerName = cardOwnerName;
        this.clientId = clientId;
        this.productsIds = productsIds;
    }
}
