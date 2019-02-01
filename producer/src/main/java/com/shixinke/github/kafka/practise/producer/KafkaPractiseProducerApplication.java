package com.shixinke.github.kafka.practise.producer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class KafkaPractiseProducerApplication {

    public static void main(String[] args) {
        SpringApplication.run(KafkaPractiseProducerApplication.class, args);
    }

}

