package com.shixinke.github.kafka.practise.common.data;

import lombok.Data;

import java.io.Serializable;

/**
 * @author shixinke
 * @version 1.0
 * @description 用户实体
 * @date 19-2-1 下午1:04
 */
@Data
public class User implements Serializable {
    private static final long serialVersionUID = -3247930189609406661L;

    private long userId;
    private String nickname;
    private String email;
    private String account;
    private String password;
    private int status;
    private long createTime;

    public User() {
    }

    public User(String nickname, String email, String account, String password, int status, long createTime) {
        this.userId = userId;
        this.nickname = nickname;
        this.email = email;
        this.account = account;
        this.password = password;
        this.status = status;
        this.createTime = createTime;
    }

    public User(long userId, String nickname, String email, String account, String password, int status, long createTime) {
        this.userId = userId;
        this.nickname = nickname;
        this.email = email;
        this.account = account;
        this.password = password;
        this.status = status;
        this.createTime = createTime;
    }

    /*@Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", nickname='" + nickname + '\'' +
                ", email='" + email + '\'' +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", status=" + status +
                ", createTime=" + createTime +
                '}';
    }*/
}
