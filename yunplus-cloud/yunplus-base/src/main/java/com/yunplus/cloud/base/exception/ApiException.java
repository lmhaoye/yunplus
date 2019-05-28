package com.yunplus.cloud.base.exception;

import lombok.Getter;
import lombok.Setter;

/**
 * @author forest.luo
 */
@Getter
@Setter
public class ApiException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    private String code;

    public ApiException(String msg) {
        super(msg);
        this.code = "01";
    }

    public ApiException(String code, String msg) {
        super(msg);
        this.code = code;
    }
}
