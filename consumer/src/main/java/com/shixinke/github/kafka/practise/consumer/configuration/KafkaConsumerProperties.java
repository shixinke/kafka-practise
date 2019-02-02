package com.shixinke.github.kafka.practise.consumer.configuration;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "spring.kafka.consumer")
@Data
public class KafkaConsumerProperties {

    private String bootstrapServers;
    private String groupId;
    private String clientId;
    private String enableAutoCommit;
    private String autoCommitIntervalMs;
    private String autoOffsetReset;
    private String keyDeserializer;
    private String valueDeserializer;
    private String subscribeTopics;
    private int concurrency;
}