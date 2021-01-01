package com.aircraft.codelab.core.common;

import com.aircraft.codelab.core.enums.ResultCode;
import com.aircraft.codelab.core.service.IReturnCode;

import java.io.Serializable;

/**
 * 2020-11-01
 * 统一返回消息实体
 *
 * @author tao.zhang
 * @since 1.0
 */
public class CommonResult<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 状态码
     */
    private int code;

    /**
     * 响应信息
     */
    private String message;

    /**
     * 响应数据
     */
    private T data;

    protected CommonResult(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <T> CommonResult<T> success() {
        return success(ResultCode.SUCCESS.getMessage(), null);
    }

    public static <T> CommonResult<T> success(String message) {
        return success(message, null);
    }

    public static <T> CommonResult<T> success(String message, T data) {
        return new CommonResult<>(ResultCode.SUCCESS.getCode(), message, data);
    }

    public static <T> CommonResult<T> failed() {
        return failed(ResultCode.FAILURE.getMessage());
    }

    public static <T> CommonResult<T> failed(String message) {
        return new CommonResult<>(ResultCode.FAILURE.getCode(), message, null);
    }

    public static <T> CommonResult<T> failed(IReturnCode returnCode) {
        return failed(returnCode, null);
    }

    public static <T> CommonResult<T> failed(IReturnCode returnCode, T data) {
        return new CommonResult<>(returnCode.getCode(), returnCode.getMessage(), data);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
