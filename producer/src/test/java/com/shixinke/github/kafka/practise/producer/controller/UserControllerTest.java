package com.shixinke.github.kafka.practise.producer.controller;

import com.shixinke.github.kafka.practise.common.data.Result;
import com.shixinke.github.kafka.practise.producer.dto.UserDTO;
import org.junit.Before;
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
public class UserControllerTest {

    @Resource
    private UserController controller;

    @Before
    public void before() {

    }

    @Test
    public void createUser() {
        UserDTO userDTO = new UserDTO();
        userDTO.setAccount("test888");
        userDTO.setEmail("test@qq.com");
        userDTO.setNickname("测试1");
        userDTO.setPassword("888888");
        Result result = controller.register(userDTO);
        Assert.isTrue(result.isSuccess(), "注册成功");
    }

}
