package com.shixinke.github.kafka.practise.producer.service;

import com.shixinke.github.kafka.practise.common.data.Result;
import com.shixinke.github.kafka.practise.producer.dto.UserDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import javax.annotation.Resource;

/**
 * @author shixinke
 * @version 1.0
 * @Description
 * @Date 19-2-3 下午12:11
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Resource
    private UserService userService;

    @Test
    public void create() {
        UserDTO userDTO = new UserDTO();
        userDTO.setAccount("test888");
        userDTO.setEmail("test@qq.com");
        userDTO.setNickname("测试1");
        userDTO.setPassword("888888");
        Result result = userService.create(userDTO);
        Assert.isTrue(result.isSuccess(), "注册成功");
    }
}
