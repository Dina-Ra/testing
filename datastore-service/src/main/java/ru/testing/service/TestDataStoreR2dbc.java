package ru.testing.service;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.testing.domain.Test;

@Service
public class TestDataStoreR2dbc implements TestDataStore {
    @Override
    public Mono<Test> saveTest(Test test) {
        return null;
    }

    @Override
    public Flux<Test> findAllTest() {
        return null;
    }
}
