package competcommerce.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    private String username;

    @Column(name = "email", length = 30)
    private String email;

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

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "email", insertable = false, updatable = false)
    private Client client;

    public User (String role, Boolean locked, Boolean disabled, String password, String username, String email) {
        this.role = role;
        this.disabled = disabled;
        this.locked = locked;
        this.email = email;
        this.username = username;
        this.password = password;
    }
}
