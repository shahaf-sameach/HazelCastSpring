package com.example.hazelcastcach;

import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class CityService {

    @Autowired
    public HazelcastInstance hazelcastInstance;

    @Cacheable("slow")
    public String slowFunction() {
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "slow response";
    }

    public String getCity(){
        return hazelcastInstance.getMap("city").getOrDefault("city", "NA").toString();
    }

    public String setCity(String city) {
        hazelcastInstance.getMap("city").put("city", city);
        return city;
    }
}
