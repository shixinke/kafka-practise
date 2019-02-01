package com.shixinke.github.kafka.practise.consumer.service.impl;

import com.shixinke.github.kafka.practise.consumer.service.UserService;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.time.Duration;

/**
 * @author shixinke
 * @version 1.0
 * @Description
 * @Date 19-2-1 下午5:07
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private KafkaConsumer kafkaConsumer;

    @Override
    @PostConstruct
    public void create() {
        while (true) {
            ConsumerRecords<String, String> records = kafkaConsumer.poll(Duration.ofSeconds(1));
            for (ConsumerRecord<String, String> record : records) {
                System.out.println(record);
            }
        }
    }
}
