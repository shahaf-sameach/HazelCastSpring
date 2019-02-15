package com.example.hazelcastcach;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;

import static java.lang.System.nanoTime;

@Slf4j
@RestController
@RequestMapping("/db")
public class DbController {

    @Autowired
    private DbService dbService;

    @GetMapping
    public ResponseEntity getEntry(@RequestParam("key") String key) {
        return ResponseEntity.ok(dbService.getEntry(key));
    }

    @PostMapping
    public ResponseEntity setEntry(@RequestBody DbEntry entry) {
        dbService.SetCity(entry.getKey(), entry.getValue());
        return ResponseEntity.ok().build();

    }

}
