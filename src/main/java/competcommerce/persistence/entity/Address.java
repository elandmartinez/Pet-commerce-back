package competcommerce.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="addresses")
@Getter
@Setter
@NoArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id", nullable = false)
    private int addressId;

    @Column(nullable = false, length = 50)
    private String city;

    @Column(nullable = false, length = 50)
    private String region;

    @Column(nullable = false, name = "client_id")
    private int clientId;

    @Column(nullable = false, length = 50)
    private String country;

    @Column(nullable = false, length = 80)
    private String street;

    public Address (
            String street,
            String city,
            String region,
            String country,
            int clientId
    ) {
        this.street = street;
        this.city = city;
        this.region = region;
        this.country = country;
        this.clientId = clientId;
    }
}
