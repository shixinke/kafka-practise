package com.shixinke.github.kafka.practise.producer.service.impl;

import com.shixinke.github.kafka.practise.common.bean.Result;
import com.shixinke.github.kafka.practise.common.entity.User;
import com.shixinke.github.kafka.practise.producer.dto.UserDTO;
import com.shixinke.github.kafka.practise.producer.service.KafkaMQService;
import com.shixinke.github.kafka.practise.producer.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.Instant;


/**
 * @author shixinke
 * @version 1.0
 * @Description
 * @Date 19-2-1 下午1:08
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private KafkaMQService kafkaMQService;

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
        kafkaMQService.send("user_reg", user.getUserId(), user);
        return Result.success(user.getUserId());
    }
}
