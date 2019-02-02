package com.shixinke.github.kafka.practise.producer.configuration;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author jiangfangtao
 * @version 1.0
 * @Description
 * @Date 19-2-2 下午4:31
 */
@Configuration
public class KafkaProducerConfiguration {

    @Resource
    private KafkaProducerProperties kafkaProducerProperties;

    public Map<String, Object> producerConfig() {
        Map<String, Object> props = new HashMap<String, Object>(8);
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaProducerProperties.getBootstrapServers());
        props.put(ProducerConfig.ACKS_CONFIG, kafkaProducerProperties.getAcks());
        props.put(ProducerConfig.BATCH_SIZE_CONFIG, kafkaProducerProperties.getBatchSize());
        props.put(ProducerConfig.BUFFER_MEMORY_CONFIG, kafkaProducerProperties.getBufferMemory());
        props.put(ProducerConfig.CLIENT_ID_CONFIG, kafkaProducerProperties.getClientId());
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, kafkaProducerProperties.getKeySerializer());
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, kafkaProducerProperties.getValueSerializer());
        return props;
    }

    @Bean
    public <V> KafkaTemplate<String, V> kafkaTemplate() {
        return new KafkaTemplate<String, V>(new DefaultKafkaProducerFactory<String, V>(producerConfig()));
    }
}
