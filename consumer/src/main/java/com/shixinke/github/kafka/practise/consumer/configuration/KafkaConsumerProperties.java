package com.shixinke.github.kafka.practise.consumer.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author shixinke
 * @version 1.0
 * @Description
 * @Date 19-2-1 下午4:05
 */
@Component
@ConfigurationProperties(prefix = "kafka.consumer")
@Data
public class KafkaConsumerProperties {

    private String bootstrapServers;
    private String groupId;
    private String enableAutoCommit;
    private String autoCommitIntervalMs;
    private String autoOffsetReset;
    private String keyDeserializer;
    private String valueDeserializer;
    private String subscribeTopics;
}
