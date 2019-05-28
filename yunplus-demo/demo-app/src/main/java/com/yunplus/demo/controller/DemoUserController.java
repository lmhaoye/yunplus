package com.yunplus.demo.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yunplus.cloud.base.dto.ServiceResultDto;
import com.yunplus.cloud.web.BaseController;
import com.yunplus.demo.api.dto.UserDto;
import com.yunplus.demo.entity.User;
import com.yunplus.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class DemoUserController extends BaseController {
    @Autowired
    private UserService userService;

    @GetMapping
    public ServiceResultDto<UserDto> list(@RequestParam(value = "page", defaultValue = "1") Integer page, @RequestParam(value = "page_size", defaultValue = "10") Integer pageSize) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        IPage<UserDto> data = userService.page(page, pageSize, queryWrapper);
        return ServiceResultDto.ok(data);
    }

    @PostMapping
    public ServiceResultDto add(UserDto user) {
        if (userService.saveOrUpdate(user)) {
            return ServiceResultDto.ok();
        }
        return ServiceResultDto.error("01", "保存失败");
    }
}
