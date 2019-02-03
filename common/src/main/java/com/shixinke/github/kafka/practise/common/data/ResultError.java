package com.shixinke.github.kafka.practise.common.data;

/**
 * @author shixinke
 * @version 1.0
 * @Description
 * @Date 19-2-2 下午4:19
 */
public enum ResultError {
    SUCCESS(200, "success"),
    PARAMETER_ERROR(4001, "参数错误"),
    VALIDATE_ERROR(4101, "验证失败"),
    CACHE_ERROR(5101, "缓存错误"),
    DATABASE_ERROR(5201, "数据库错误"),
    APP_ERROR(5301, "系统错误"),
    UNKNOWN_ERROR(9999, "未知错误");
    private int code;
    private String message;

    ResultError(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}

