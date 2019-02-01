package com.shixinke.github.kafka.practise.producer.service.impl;

import com.shixinke.github.kafka.practise.producer.service.KafkaMQService;
import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

/**
 * @author shixinke
 * @version 1.0
 * @Description
 * @Date 19-2-1 下午2:06
 */
@Service
public class KafkaMQServiceImpl implements KafkaMQService {

    @Resource
    private KafkaProducer kafkaProducer;

    @Override
    public <K, V> Future<RecordMetadata> send(String topic, K key, V content) {
        ProducerRecord<String, V> record = new ProducerRecord<String, V>(topic, String.valueOf(key), content);
        return kafkaProducer.send(record);
    }

    @Override
    public <K, V> void send(String topic, K key, V content, Callback callback) {
        ProducerRecord<String, V> record = new ProducerRecord<String, V>(topic, String.valueOf(key), content);
        kafkaProducer.send(record, callback);
    }
}
