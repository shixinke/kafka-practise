package com.shixinke.github.kafka.practise.common.util;

import org.apache.kafka.common.serialization.Deserializer;

import java.util.Map;

/**
 * @author shixinke
 * @version 1.0
 * @Description
 * @Date 19-2-1 下午5:43
 */
public class KafkaObjectDeserializer implements Deserializer<Object> {
    @Override
    public void configure(Map<String, ?> config, boolean isKey) {

    }

    /**
     * 反序列化方法
     * @param topic　主题
     * @param data　消息内容
     * @return
     */
    @Override
    public Object deserialize(String topic, byte[] data) {
        return Converter.byteArray2Bean(data);
    }

    @Override
    public void close() {

    }
}

