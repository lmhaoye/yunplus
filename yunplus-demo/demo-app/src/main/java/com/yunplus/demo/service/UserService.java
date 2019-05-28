package com.yunplus.demo.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.collect.Lists;
import com.yunplus.demo.api.dto.UserDto;
import com.yunplus.demo.entity.User;
import com.yunplus.demo.mapper.UserMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService extends ServiceImpl<UserMapper, User> implements IService<User> {
    public IPage<UserDto> page(Integer current, Integer size, QueryWrapper<User> queryWrapper) {
        IPage<User> data = this.page(new Page<>(current, size), queryWrapper);
        IPage<UserDto> dtoIPage = new Page<>(current, size, data.getTotal());
        dtoIPage.setPages(data.getPages());
        List<UserDto> list = Lists.newArrayList();
        for (User record : data.getRecords()) {
            UserDto temp = new UserDto();
            BeanUtils.copyProperties(record, temp);
            list.add(temp);
        }
        dtoIPage.setRecords(list);
        return dtoIPage;
    }

    public Boolean saveOrUpdate(UserDto userDto) {
        User user = new User();
        BeanUtils.copyProperties(userDto, user);
        this.saveOrUpdate(user);
        userDto.setId(user.getId());
        return userDto.getId() != null;
    }
}
