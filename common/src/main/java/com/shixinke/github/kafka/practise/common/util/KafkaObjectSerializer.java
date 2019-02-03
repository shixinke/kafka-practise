package com.shixinke.github.kafka.practise.common.util;


import org.apache.kafka.common.serialization.Serializer;

import java.util.Map;

/**
 * @author shixinke
 * @version 1.0
 * @Description
 * @Date 19-2-1 下午2:56
 */
public class KafkaObjectSerializer implements Serializer<Object> {

    @Override
    public void configure(Map<String, ?> config, boolean isKey) {

    }

    /**
     * 实现话类
     * @param topic　主题
     * @param data 消息内容数据
     * @return
     */
    @Override
    public byte[] serialize(String topic, Object data) {
        return Converter.bean2ByteArray(data);
    }

    @Override
    public void close() {

    }
}

