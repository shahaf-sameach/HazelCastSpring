package com.example.hazelcastcach;

import com.hazelcast.core.HazelcastInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class DbService {

    @Autowired
    public HazelcastInstance hazelcastInstance;

    public String getEntry(String key){
        return hazelcastInstance.getMap("db").getOrDefault(key, "NA").toString();
    }

    public void SetCity(String key, String value) {
        hazelcastInstance.getMap("db").put(key, value);
    }
}
