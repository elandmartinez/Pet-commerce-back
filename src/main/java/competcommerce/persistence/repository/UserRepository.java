package competcommerce.persistence.repository;

import competcommerce.persistence.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String> {
}
