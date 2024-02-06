package competcommerce.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="clients")
@Getter
@Setter
@NoArgsConstructor
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "client_id", nullable = false)
    private int clientId;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false, length = 100)
    private String email;

    @Column(nullable = false, name = "phone_number")
    private int phoneNumber;

    @Column(nullable = false, name = "national_code")
    private short nationalCode;

    public Client (
            String name,
            String email,
            int phoneNumber,
            short nationalCode
    ) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.nationalCode = nationalCode;
    }
}
