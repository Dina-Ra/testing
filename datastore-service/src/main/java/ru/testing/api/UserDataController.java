package ru.testing.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;
import ru.testing.dto.UserDto;
import ru.testing.service.UserDataStore;

@RestController
public class UserDataController {
    private static final Logger log = LoggerFactory.getLogger(UserDataController.class);
    private final UserDataStore userDataStore;
    private final Scheduler workerPool;

    public UserDataController(UserDataStore userDataStore, Scheduler workerPool) {
        this.userDataStore = userDataStore;
        this.workerPool = workerPool;
    }

    @GetMapping(value = "/user/", produces = MediaType.APPLICATION_NDJSON_VALUE)
    public Mono<UserDto> getUserByLogin(@PathVariable("roomId") String username) {
        return userDataStore.findByUsername(username)
                .map(user -> new UserDto(user.getUsername()))
                .subscribeOn(workerPool);
    }

    @PostMapping(value = "/user/")
    public Mono<Long> saveUser() {
        return null;
    }
}
