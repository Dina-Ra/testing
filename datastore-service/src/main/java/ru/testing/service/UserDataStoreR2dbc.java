package ru.testing.service;


import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import ru.testing.domain.User;
import ru.testing.repository.UserRepository;

@Service
public class UserDataStoreR2dbc implements UserDataStore {

    private final UserRepository userRepository;

    public UserDataStoreR2dbc(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Mono<User> saveUser(User user) {
        return null;
    }

    @Override
    public Mono<UserDetails> findByUsername(String username) {
        return userRepository.findByUsername(username)
                .cast(UserDetails.class);
    }
}
