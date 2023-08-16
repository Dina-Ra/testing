package ru.testing.service;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.testing.domain.User;
import ru.testing.domain.Verification;

@Service
public class VerificationDataStoreR2dbc implements VerificationDataStore {
    @Override
    public Mono<Verification> saveVerification(Verification verification) {
        return null;
    }

    @Override
    public Flux<Verification> loadPastVerification(User user) {
        return null;
    }
}
