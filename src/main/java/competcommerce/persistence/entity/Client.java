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
    @Column(nullable = false, length = 100)
    public String email;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false, length=50)
    private String password;

    @Column(nullable = false, name = "phone_number")
    private int phoneNumber;

    @Column(nullable = false, name = "national_code")
    private short nationalCode;

    public Client (
            String name,
            String email,
            String password,
            int phoneNumber,
            short nationalCode
    ) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.nationalCode = nationalCode;
    }
}
