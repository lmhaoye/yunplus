package com.yunplus.cloud.web;

import com.yunplus.cloud.base.dto.ServiceResultDto;
import com.yunplus.cloud.base.exception.ApiException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
@Slf4j
public class ExceptionAdvice {
    @ExceptionHandler(Exception.class)
    public ServiceResultDto defaultException(HttpServletRequest request, Exception e) {
        log.error("错误异常：", e);
        String msg = e.getMessage();
        String code = "01";
        if (e instanceof SecurityException) {
            msg = "安全错误";
            code ="02";
        } else if (e instanceof MethodArgumentTypeMismatchException) {
            msg = "参数匹配错误，请检查参数";
            code ="03";
        }
        return ServiceResultDto.systemError(code, msg);
    }

    @ExceptionHandler(ApiException.class)
    public ServiceResultDto businessException(HttpServletRequest request, ApiException e) {
        log.error("业务错误：", e);
        return ServiceResultDto.error(e.getCode(), e.getMessage());
    }
}
