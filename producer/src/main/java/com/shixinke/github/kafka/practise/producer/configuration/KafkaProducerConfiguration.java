package com.shixinke.github.kafka.practise.producer.configuration;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import java.util.Properties;

/**
 * @author shixinke
 * @version 1.0
 * @Description
 * @Date 19-2-1 下午1:44
 */
@Configuration
public class KafkaProducerConfiguration {

    @Resource
    private KafkaProducerProperties propertiesConfiguration;

    @Bean
    public <K, V> KafkaProducer getProducer() {
        KafkaProducer<K, V> producer = new KafkaProducer<K, V>(getProperties(propertiesConfiguration));
        return producer;
    }

    public static Properties getProperties(KafkaProducerProperties config) {
        Properties props = new Properties();
        props.put("bootstrap.servers", config.getBootstrapServers());
        props.put("acks", config.getAcks());
        props.put("delivery.timeout.ms", config.getDeliveryTimeoutMs());
        props.put("batch.size", config.getBatchSize());
        props.put("linger.ms", config.getLingerMs());
        props.put("buffer.memory", config.getBufferMemory());
        props.put("key.serializer", config.getKeySerializer());
        props.put("value.serializer", config.getValueSerializer());
        return props;
    }
}
