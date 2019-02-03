package com.shixinke.github.kafka.practise.producer.service.impl;

import com.shixinke.github.kafka.practise.producer.service.KafkaMQProducerService;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.Future;

/**
 * @author shixinke
 * @version 1.0
 * @Description
 * @Date 19-2-1 下午2:06
 */
@Service
public class KafkaMQProducerServiceImpl implements KafkaMQProducerService {

    /**
     * 在生产者配置中声明的KafkaTemplate的Bean类
     */
    @Resource
    private KafkaTemplate kafkaProducer;

    @Override
    public <K, V> Future<RecordMetadata> send(String topic, K key, V content) {
        ProducerRecord<String, V> record = new ProducerRecord<String, V>(topic, String.valueOf(key), content);
        return kafkaProducer.send(record);
    }



}
