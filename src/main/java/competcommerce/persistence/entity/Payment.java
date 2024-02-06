package competcommerce.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "payments")
@Getter
@Setter
@NoArgsConstructor
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "payment_id")
    private int paymentId;

    @Column(nullable = false, columnDefinition = "Decimal(9,2)", name = "paid_amount")
    private float paidAmount;

    @Column(nullable = false, name = "payment_method_id")
    private int paymentMethodId;

    @Column(nullable = false, name = "client_id")
    private int clientId;

    @Column(nullable = false, name = "order_id")
    private int orderId;

    public Payment (
            float paidAmount,
            int paymentMethodId,
            int clientId,
            int orderId
    ) {
        this.paidAmount = paidAmount;
        this.paymentMethodId = paymentMethodId;
        this.clientId = clientId;
        this.orderId = orderId;
    }
}
