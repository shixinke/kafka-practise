package com.shixinke.github.kafka.practise.producer.service;

import com.shixinke.github.kafka.practise.common.data.Result;
import com.shixinke.github.kafka.practise.producer.dto.UserDTO;

public interface UserService {
    public Result create(UserDTO userDTO);
}
