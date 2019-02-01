package com.shixinke.github.kafka.practise.consumer.configuration;

import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Optional;
import java.util.Properties;

/**
 * @author shixinke
 * @version 1.0
 * @Description
 * @Date 19-2-1 下午4:05
 */
@Configuration
public class KafkaConsumerConfiguration {

    @Resource
    private KafkaConsumerProperties kafkaProperties;

    @Bean
    public <K, V> KafkaConsumer getConsumer() {
        kafkaProperties = getKafkaProperties(kafkaProperties);
        System.out.println(kafkaProperties);
        KafkaConsumer<K, V> consumer = new KafkaConsumer<>(getProperties(kafkaProperties));
        String[] topics = kafkaProperties.getSubscribeTopics().split(",");
        consumer.subscribe(Arrays.asList(topics));
        return consumer;
    }

    public static KafkaConsumerProperties getKafkaProperties(KafkaConsumerProperties kafkaProperties) {
        Optional<KafkaConsumerProperties> config = Optional.ofNullable(kafkaProperties);
        config.orElse(new KafkaConsumerProperties());
        return config.get();
    }


    public static Properties getProperties(KafkaConsumerProperties config) {
        Properties props = new Properties();
        props.put("bootstrap.servers", config.getBootstrapServers());
        props.put("group.id", config.getGroupId());
        props.put("enable.auto.commit", config.getEnableAutoCommit());
        props.put("auto.offset.reset", config.getAutoOffsetReset());
        props.put("auto.commit.interval.ms", config.getAutoCommitIntervalMs());
        props.put("key.deserializer", config.getKeyDeserializer());
        props.put("value.deserializer", config.getValueDeserializer());
        return props;
    }
}
