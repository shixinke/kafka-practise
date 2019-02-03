package com.shixinke.github.kafka.practise.producer.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.Metric;
import org.apache.kafka.common.MetricName;
import org.apache.kafka.common.PartitionInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author shixinke
 * @version 1.0
 * @Description
 * @Date 19-2-3 上午11:15
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@Slf4j
public class KafkaProducerTest {

    @Resource
    private KafkaTemplate kafkaProducer;

    @Test
    public void partitions() {
        List<PartitionInfo> partitionInfoList = kafkaProducer.partitionsFor("user_reg");
        log.info("分区信息：{}", partitionInfoList);
        Assert.isTrue(partitionInfoList.size() > 0, "分区数："+partitionInfoList.size());
    }

    @Test
    public void metrics() {
        Map<MetricName, Metric> metricMap  = kafkaProducer.metrics();
        log.info("指标信息：{}", metricMap);
        Assert.isTrue(metricMap.size() > 0, "指标信息："+metricMap.size());
    }
}
