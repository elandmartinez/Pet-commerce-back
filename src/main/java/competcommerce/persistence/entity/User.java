package competcommerce.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
public class User {
    @Getter
    @Id
    @Column(name = "user_name", nullable = false, length = 30)
    private String userName;

    @Getter
    @Column(nullable = false, length = 10)
    private String role;

    @Column (nullable = false, length = 250)
    private String password;

    @Getter
    @Column (nullable = false, columnDefinition = "BOOLEAN")
    private Boolean locked;

    @Column (nullable = false, columnDefinition = "BOOLEAN")
    private Boolean disabled;

    public User (String role, Boolean locked, Boolean disabled, String password, String userName) {
        this.role = role;
        this.disabled = disabled;
        this.locked = locked;
        this.userName = userName;
        this.password = password;
    }
}
