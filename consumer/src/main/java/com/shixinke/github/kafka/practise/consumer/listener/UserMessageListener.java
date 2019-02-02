package com.shixinke.github.kafka.practise.consumer.listener;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author jiangfangtao
 * @version 1.0
 * @Description
 * @Date 19-2-2 下午5:22
 */
@Component
@Slf4j
public class UserMessageListener {

    @KafkaListener(id ="user_reg", topics = "user_reg", containerFactory = "userContainerFactory")
    public void subscribeCreateUser(List<ConsumerRecord<String, String>> records, Acknowledgment ack) {
        try {
            log.info("收到消息：{}", records);
            /**
             * 手动提交偏移量
             */
            ack.acknowledge();
        } catch (Exception ex) {
            try {
                ack.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
