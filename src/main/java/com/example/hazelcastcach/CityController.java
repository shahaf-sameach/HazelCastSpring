package com.example.hazelcastcach;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

import static java.lang.System.nanoTime;

@RestController
public class CityController {

    private final Logger logger = LoggerFactory.getLogger(CityController.class);

    @Autowired
    private CityService cityService;

    @GetMapping("/slow")
    public String getSlowResponse() {
        String logFormat = "call took {} millis with result: {}";
        long start1 = nanoTime();
        String response = cityService.slowFunction();
        long end1 = nanoTime();
        logger.info(logFormat, TimeUnit.NANOSECONDS.toMillis(end1 - start1), response);
        return response;
    }

    @GetMapping("/city")
    public String getCity() {
        String city = cityService.getCity();
        return city;
    }

    @GetMapping("/city/{city}")
    public String setCity(@PathVariable String city) {
        return cityService.setCity(city);
    }
}
