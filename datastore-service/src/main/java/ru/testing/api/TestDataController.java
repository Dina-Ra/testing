package ru.testing.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;
import ru.testing.dto.TestDto;
import ru.testing.service.TestDataStore;

@RestController
public class TestDataController {
    private static final Logger log = LoggerFactory.getLogger(TestDataController.class);
    private final TestDataStore testDataStore;
    private final Scheduler workerPool;

    public TestDataController(TestDataStore testDataStore, Scheduler workerPool) {
        this.testDataStore = testDataStore;
        this.workerPool = workerPool;
    }

    @GetMapping(value = "/tests", produces = MediaType.APPLICATION_NDJSON_VALUE)
    public Flux<TestDto> getRandomTests() {
        return testDataStore.findAllTest()
                .map(test -> new TestDto(test.getText(), test.getAnswers()))
                .subscribeOn(workerPool);
    }

    @PostMapping(value = "/test/")
    public Mono<Long> saveTest() {
        return null;
    }
}
