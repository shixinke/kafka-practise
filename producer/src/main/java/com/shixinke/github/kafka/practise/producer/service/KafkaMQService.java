package com.shixinke.github.kafka.practise.producer.service;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.concurrent.Future;

/**
 * @author shixinke
 * @version 1.0
 * @Description
 * @Date 19-2-1 下午2:05
 */
public interface KafkaMQService {
    public <K, V> Future<RecordMetadata> send(String topic, K key, V content);

    public <K, V> void send(String topic, K key, V content, Callback callback);
}
