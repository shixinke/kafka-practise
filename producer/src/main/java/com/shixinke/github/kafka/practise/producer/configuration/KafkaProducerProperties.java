package com.shixinke.github.kafka.practise.producer.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Properties;

/**
 * @author shixinke
 * @version 1.0
 * @Description
 * @Date 19-2-1 下午1:56
 */
@Component
@ConfigurationProperties(prefix = "kafka.producer")
@Data
public class KafkaProducerProperties {

    private String bootstrapServers;
    private String acks;
    private String deliveryTimeoutMs;
    private String batchSize;
    private String lingerMs;
    private String bufferMemory;
    private String keySerializer;
    private String valueSerializer;

}
