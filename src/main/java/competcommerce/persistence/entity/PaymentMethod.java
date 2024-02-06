package competcommerce.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "payment-methods")
@Getter
@Setter
@NoArgsConstructor
public class PaymentMethod {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_method_id", nullable = false)
    private int paymentMethodId;

    @Column(nullable = false, name = "card_number")
    private Long cardNumber;

    @Column(nullable = false, length = 5, name = "card_expiration_date")
    private String cardExpirationDate;

    @Column(nullable = false, name = "card_code")
    private short cardCode;

    @Column(nullable = false, length = 50, name = "ownerName")
    private String ownerName;

    @Column(nullable = false, name = "client_id")
    private int clientId;

    public PaymentMethod (
            Long cardNumber,
            String cardExpirationDate,
            short cardCode,
            String ownerName,
            int clientId
    ) {
        this.cardNumber = cardNumber;
        this.cardExpirationDate = cardExpirationDate;
        this.cardCode = cardCode;
        this.ownerName = ownerName;
        this.clientId = clientId;
    }
}
