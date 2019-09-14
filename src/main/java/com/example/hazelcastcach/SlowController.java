package com.example.hazelcastcach;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.concurrent.TimeUnit;

import static java.lang.System.nanoTime;

@Slf4j
@RestController
public class SlowController {

    @Autowired
    private SlowService slowService;

    @GetMapping("/ping")
    public Mono<String> ping() {
        return Mono.just("pong");
    }

    @GetMapping("/slow")
    public Mono<String> getSlowResponse() {
        return Mono.fromCallable(() -> {
            long start1 = nanoTime();
            String response = slowService.slowFunction();
            long end1 = nanoTime();
            log.info("call took {} millis with result: {}", TimeUnit.NANOSECONDS.toMillis(end1 - start1), response);
            return response + " took " + TimeUnit.NANOSECONDS.toMillis(end1 - start1);
        });
    }

}
