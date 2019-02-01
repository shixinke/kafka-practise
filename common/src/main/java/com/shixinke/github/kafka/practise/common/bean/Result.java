package com.shixinke.github.kafka.practise.common.bean;

import lombok.Data;

/**
 * @author shixinke
 * @version 1.0
 * @Description
 * @Date 19-2-1 下午1:10
 */
@Data
public class Result<T> {
    private int code = ResultError.SUCCESS.getCode();
    private String message = ResultError.SUCCESS.getMessage();
    private boolean success = true;
    private T data;

    public Result() {
    }

    public Result(int code) {
        this.code = code;
    }

    public Result(int code, String message) {
        this(code);
        this.message = message;
    }

    public Result(int code, String message, boolean success) {
        this(code, message);
        this.success = success;
    }

    public Result(int code, String message, boolean success, T data) {
        this(code, message, success);
        this.data = data;
    }

    public static  Result success(int code, String message) {
        return new Result(code, message, true);
    }

    public static  <T> Result success(int code, String message, T data) {
        return new Result(code, message, true, data);
    }

    public static <T> Result success(T data) {
        return new Result(ResultError.SUCCESS.getCode(), ResultError.SUCCESS.getMessage(), true, data);
    }

    public static  Result success(String message) {
        return new Result(ResultError.SUCCESS.getCode(), message, true);
    }

    public static  Result success() {
        return new Result(ResultError.SUCCESS.getCode(), ResultError.SUCCESS.getMessage(), true);
    }

    public static Result error(int code, String message) {
        return new Result(code, message, false);
    }

    public static Result error(String message) {
        return new Result(ResultError.UNKNOWN_ERROR.getCode(), message, false);
    }

    public static Result error() {
        return new Result(ResultError.UNKNOWN_ERROR.getCode(), ResultError.UNKNOWN_ERROR.getMessage(), false);
    }
}
