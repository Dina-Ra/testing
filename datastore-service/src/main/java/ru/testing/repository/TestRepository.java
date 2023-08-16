package ru.testing.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import ru.testing.domain.Test;

public interface TestRepository extends ReactiveCrudRepository<Test, Long> {
}
