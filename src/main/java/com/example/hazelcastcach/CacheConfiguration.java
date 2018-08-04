package com.example.hazelcastcach;

import com.hazelcast.core.Hazelcast;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;

import com.hazelcast.core.HazelcastInstance;

import com.hazelcast.spring.cache.HazelcastCacheManager;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CacheConfiguration {

    @Bean
    public HazelcastInstance hazelcastInstance() {
        return Hazelcast.newHazelcastInstance();
    }

    @Bean
    public CacheManager cacheManager() {
        return new HazelcastCacheManager(hazelcastInstance());
    }
}
