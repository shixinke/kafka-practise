package com.shixinke.github.kafka.practise.producer.service.impl;

import com.shixinke.github.kafka.practise.common.data.Result;
import com.shixinke.github.kafka.practise.common.data.User;
import com.shixinke.github.kafka.practise.producer.dto.UserDTO;
import com.shixinke.github.kafka.practise.producer.service.KafkaMQProducerService;
import com.shixinke.github.kafka.practise.producer.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.Instant;

/**
 * @author jiangfangtao
 * @version 1.0
 * @Description
 * @Date 19-2-2 下午4:54
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private KafkaMQProducerService producerService;

    @Override
    public Result create(UserDTO userDTO) {
        User user = new User(userDTO.getNickname(), userDTO.getEmail(), userDTO.getAccount(), userDTO.getPassword(), 0, Instant.now().getEpochSecond());
        /**
         * 数据操作在此不再赘述(插入数据库，更新缓存)
         */
        user.setUserId(3000001);

        /**
         * 上面操作成功后，向消息队列发送一条消息，比如通知邮件服务要发邮件
         */
        producerService.send("user_reg", user.getUserId(), user);
        return Result.success(user.getUserId());
    }
}
