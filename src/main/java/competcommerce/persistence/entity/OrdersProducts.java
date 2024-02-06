package competcommerce.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="orders_products")
@Getter
@Setter
@NoArgsConstructor
public class OrdersProducts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "order_product_id")
    private int orderProductId;


    @ManyToOne
    @JoinColumn(name = "order_id", insertable = false, updatable = false)
    private Order order;

    @ManyToOne
    @JoinColumn(name = "product_id", insertable = false, updatable = false)
    private Product product;
}