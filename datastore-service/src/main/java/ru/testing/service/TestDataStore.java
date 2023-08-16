package ru.testing.service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.testing.domain.Test;

public interface TestDataStore {
    Mono<Test> saveTest(Test test);

    Flux<Test> findAllTest();
}
