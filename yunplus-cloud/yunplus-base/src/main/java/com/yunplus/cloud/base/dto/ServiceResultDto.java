package com.yunplus.cloud.base.dto;

import com.yunplus.cloud.base.exception.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Description 通用返回对象
 * @Author fporest.luo
 * @Date 2019/5/15 19:22
 * Version      1.0
 **/
@Data
public class ServiceResultDto<T> {

    private String code;

    private String msg;

    private T data;


    private ServiceResultDto(String code, String msg, T data) {
        this.code = code.equals(ErrorCode.CODE_SUCCESS) ? code : ErrorCode.appId + code;
        this.msg = msg;
        this.data = data;
    }

    public static ServiceResultDto ok() {
        return ok(null);
    }

    public static ServiceResultDto ok(Object data) {
        return new ServiceResultDto(ErrorCode.CODE_SUCCESS, ErrorCode.CODE_SUCCESS_MSG, data);
    }

    public static ServiceResultDto error(String errorCode, String errorMsg) {
        if (errorCode.length() == 2) {
            errorCode = ErrorCode.CODE_PREFIX_BUSINESS_ABNORMAL + errorCode;
        }
        return new ServiceResultDto(errorCode, errorMsg, null);
    }

    public static ServiceResultDto systemError(String errorCode, String errorMsg) {
        return error(ErrorCode.CODE_PREFIX_SYSTEM + errorCode, errorMsg);
    }
}
