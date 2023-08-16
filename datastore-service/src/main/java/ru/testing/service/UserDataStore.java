package ru.testing.service;

import org.springframework.security.core.userdetails.ReactiveUserDetailsService;
import reactor.core.publisher.Mono;
import ru.testing.domain.User;

public interface UserDataStore extends ReactiveUserDetailsService {
    Mono<User> saveUser(User user);

}
