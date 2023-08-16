package ru.testing.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;
import ru.testing.domain.User;
import ru.testing.dto.VerificationDto;
import ru.testing.service.VerificationDataStore;

@RestController
public class VerificationDataController {
    private static final Logger log = LoggerFactory.getLogger(VerificationDataController.class);
    private final VerificationDataStore verificationDataStore;
    private final Scheduler workerPool;

    public VerificationDataController(VerificationDataStore verificationDataStore, Scheduler workerPool) {
        this.verificationDataStore = verificationDataStore;
        this.workerPool = workerPool;
    }

    @GetMapping(value = "/verification/", produces = MediaType.APPLICATION_NDJSON_VALUE)
    public Flux<VerificationDto> getVerificationByPastCreateDate(@RequestBody User user) {
        return verificationDataStore.loadPastVerification(user)
                .map(verification -> new VerificationDto(verification.getResult(), verification.getCreateDate()))
                .subscribeOn(workerPool);
    }

    @PostMapping(value = "/verification/")
    public Mono<Long> saveVerification() {
        return null;
    }
}
