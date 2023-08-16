package ru.testing.service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.testing.domain.User;
import ru.testing.domain.Verification;

public interface VerificationDataStore {

    Mono<Verification> saveVerification(Verification verification);

    Flux<Verification> loadPastVerification(User user);
}
