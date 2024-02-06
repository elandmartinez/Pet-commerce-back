package competcommerce.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;

@Entity
@Table(name = "orders")
@Getter
@Setter
@NoArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id", nullable = false)
    private int purchaseOrderId;

    @Column(nullable = false, columnDefinition = "DATETIME", name = "order_date")
    private LocalDate purchaseDate;

    @Column(nullable = false, length = 20)
    private String status;

    @Column(nullable = false, name = "client_id")
    private int clientId;

    @Column(nullable = false, name = "total_products")
    private int totalProducts;

    @Column(nullable = false, name = "payment_id")
    private int paymentId;

    public Order(
            LocalDate purchaseDate,
            String status,
            int clientId,
            int totalProducts,
            int paymentId
    ) {
        this.purchaseDate = purchaseDate;
        this.status = status;
        this.clientId = clientId;
        this.totalProducts = totalProducts;
        this.paymentId = paymentId;
    }

    @ManyToMany
    @JoinTable(
            name = "orders_products",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private ArrayList<Product> products;
}
