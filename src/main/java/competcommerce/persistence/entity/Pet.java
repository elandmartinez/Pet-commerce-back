package competcommerce.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "pets")
@Getter
@Setter
@NoArgsConstructor
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pet_id", nullable = false)
    private int petId;

    @Column(nullable = false, length = 20)
    private String name;

    @Column(nullable = false, columnDefinition = "timestamp", name = "birth_date")
    private LocalDate birthDate;

    @Column(nullable = false, length = 20)
    private String specie;

    @Column(nullable = false, name = "client_id")
    private int clientId;

    public Pet (
            String name,
            LocalDate birthDate,
            String specie,
            int clientId
    ) {
        this.name = name;
        this.birthDate = birthDate;
        this.specie = specie;
        this.clientId = clientId;
    }
}
