package com.shixinke.github.kafka.practise.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class KafkaPractiseConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(KafkaPractiseConsumerApplication.class, args);
    }

}

