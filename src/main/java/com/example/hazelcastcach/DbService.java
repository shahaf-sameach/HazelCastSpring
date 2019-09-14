package com.example.hazelcastcach;

import com.hazelcast.core.HazelcastInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class DbService {

    @Autowired
    public HazelcastInstance hazelcastInstance;

    public String getEntry(String key){
        return hazelcastInstance.getMap("db").getOrDefault(key, "Na").toString();
    }

    public void setEntry(String key, String value) {
        hazelcastInstance.getMap("db").put(key, value);
    }

}
