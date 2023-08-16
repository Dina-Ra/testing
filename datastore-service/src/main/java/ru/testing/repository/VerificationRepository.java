package ru.testing.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import ru.testing.domain.Verification;

public interface VerificationRepository extends ReactiveCrudRepository<Verification, Long> {
}
