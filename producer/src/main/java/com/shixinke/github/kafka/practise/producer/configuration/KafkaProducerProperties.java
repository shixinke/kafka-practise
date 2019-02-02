package com.shixinke.github.kafka.practise.producer.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author jiangfangtao
 * @version 1.0
 * @Description
 * @Date 19-2-2 下午4:33
 */
@Component
@ConfigurationProperties(prefix = "spring.kafka.producer")
@Data
public class KafkaProducerProperties {
    private String batchSize;
    private String acks;
    private String bootstrapServers;
    private Long bufferMemory;
    private String clientId;
    private String keySerializer;
    private String valueSerializer;
}
