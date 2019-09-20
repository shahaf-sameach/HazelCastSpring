package com.example.hazelcastcach;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping("/db")
public class DbController {

    @Autowired
    private DbService dbService;

    @GetMapping
    public Mono<ResponseEntity> getEntry(@RequestParam("key") String key) {
        return Mono.fromCallable(() -> ResponseEntity.ok(dbService.getEntry(key)));
    }

    @PostMapping
    public Mono<ResponseEntity> setEntry(@RequestBody DbEntry entry) {
        return Mono.fromCallable(() -> {
            if (entry.isInvalid())
                return ResponseEntity.badRequest().build();

            dbService.setEntry(entry.getKey(), entry.getValue());
            return ResponseEntity.ok().build();
        });
    }

}
