package com.shixinke.github.kafka.practise.common.util;



import org.apache.kafka.common.serialization.Serializer;

import java.util.Map;


/**
 * @author shixinke
 * @version 1.0
 * @Description
 * @Date 19-2-1 下午2:56
 */
public class KafkaSerializer implements Serializer<Object> {

    @Override
    public void configure(Map<String, ?> config, boolean isKey) {

    }

    @Override
    public byte[] serialize(String topic, Object data) {
        return Converter.bean2ByteArray(data);
    }

    @Override
    public void close() {

    }
}
