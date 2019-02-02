package com.shixinke.github.kafka.practise.producer.dto;



import lombok.Data;

/**
 * @author shixinke
 * @version 1.0
 * @Description
 * @Date 19-2-1 下午1:08
 */
@Data
public class UserDTO {
    private String nickname;
    private String account;
    private String email;
    private String password;

    @Override
    public String toString() {
        return "UserDTO{" +
                "nickname='" + nickname + '\'' +
                ", account='" + account + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
