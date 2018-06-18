package by.bogdan.springrestauth.repository;

import by.bogdan.springrestauth.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
