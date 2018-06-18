package by.bogdan.springrestauth;

import by.bogdan.springrestauth.model.Role;
import by.bogdan.springrestauth.model.User;
import by.bogdan.springrestauth.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;

import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class SpringRestAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringRestAuthApplication.class, args);
    }

    @Autowired
    public void authenticationManager(AuthenticationManagerBuilder builder, UserRepository userRepository) throws Exception {
        if (userRepository.count() == 0) {
            userRepository.save(
                    new User("user", "user",
                            Stream.of(new Role("USER"), new Role("ACTUATOR")).collect(Collectors.toSet()))
            );
        }
        builder.userDetailsService((username) -> new CustomUserDetails(userRepository.findByUsername(username)));
    }
}
