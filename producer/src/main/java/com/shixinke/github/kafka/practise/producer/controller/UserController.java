package com.shixinke.github.kafka.practise.producer.controller;

import com.shixinke.github.kafka.practise.common.bean.Result;
import com.shixinke.github.kafka.practise.producer.dto.UserDTO;
import com.shixinke.github.kafka.practise.producer.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author shixinke
 * @version 1.0
 * @Description
 * @Date 19-2-1 下午1:07
 */
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Resource
    private UserService userService;

    @PostMapping("register")
    public Result register(UserDTO userDTO) {
        Result result = null;
        try {
            result = userService.create(userDTO);
        } catch (Exception ex) {
            log.error("注册出错:", ex);
            result = Result.error(ex.getMessage());
        }
        return result;
    }
}
