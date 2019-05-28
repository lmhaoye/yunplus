package com.yunplus.cloud.base.exception;

import lombok.Getter;
import lombok.Setter;

/**
 * @author forest.luo
 * 错误码
 */
@Getter
@Setter
public class ErrorCode {
    /**
     * 系统模块ID
     */
    public static String appId = "";

    /**
     * 系统异常前缀
     */
    public static final String CODE_PREFIX_SYSTEM = "1";
    /**
     * 业务非正常返回前缀
     */
    public static final String CODE_PREFIX_BUSINESS_ABNORMAL = "2";
    /**
     * 业务正常返回前缀
     */
    public static final String CODE_PREFIX_BUSINESS_NORMAL = "3";

    /**
     * 系统成功返回错误码
     */
    public static final String CODE_SUCCESS = "0";
    public static final String CODE_SUCCESS_MSG = "请求成功";

    public static void init(String appId) {
        ErrorCode.appId = appId;
    }

}
