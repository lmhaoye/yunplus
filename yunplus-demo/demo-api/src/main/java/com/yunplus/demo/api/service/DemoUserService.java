package com.yunplus.demo.api.service;

import com.yunplus.cloud.base.dto.ServiceResultDto;
import com.yunplus.demo.api.dto.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 定义给外部依赖直接使用的服务
 */
@FeignClient("demo-app")
public interface DemoUserService {
    @GetMapping("user")
    ServiceResultDto<UserDto> list(@RequestParam(value = "page", defaultValue = "1") Integer page, @RequestParam(value = "page_size", defaultValue = "10") Integer pageSize);
    @PostMapping("user")
    ServiceResultDto add(UserDto user);


}
