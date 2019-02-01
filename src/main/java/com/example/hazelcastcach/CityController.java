package com.example.hazelcastcach;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

import static java.lang.System.nanoTime;

@Slf4j
@RestController
public class CityController {

    @Autowired
    private CityService cityService;

    @GetMapping("/slow")
    public String getSlowResponse() {
        long start1 = nanoTime();
        String response = cityService.slowFunction();
        long end1 = nanoTime();
        log.info(String.format("call took {} millis with result: {}", TimeUnit.NANOSECONDS.toMillis(end1 - start1), response));
        return response + " took " + TimeUnit.NANOSECONDS.toMillis(end1 - start1);
    }

    @GetMapping("/city")
    public String getCity(@RequestParam(value = "city", required = false) String city) {
        if (city == null)
            return cityService.getCity();

        return cityService.setCity(city);
    }

}
