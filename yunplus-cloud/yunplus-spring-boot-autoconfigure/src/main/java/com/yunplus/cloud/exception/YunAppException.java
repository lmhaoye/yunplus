package com.yunplus.cloud.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class YunAppException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public YunAppException(String msg) {
        super(msg);
    }
}
