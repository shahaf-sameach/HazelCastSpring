package com.example.hazelcastcach;

import com.hazelcast.core.Cluster;
import com.hazelcast.core.HazelcastInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;


@Component
public class HazelcastResponseHeaderWebFilter implements WebFilter {

    @Autowired
    private HazelcastInstance hazelcastInstance;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
        String value = "NA";
        Cluster cluster = hazelcastInstance.getCluster();
        if (cluster != null)
            value = cluster.getLocalMember().getUuid();

        exchange.getResponse()
                .getHeaders()
                .add("X-Instance-Id", value);
        return chain.filter(exchange);
    }
}
