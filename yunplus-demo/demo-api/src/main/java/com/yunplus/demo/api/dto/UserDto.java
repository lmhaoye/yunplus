package com.yunplus.demo.api.dto;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

@Data
public class UserDto {
    private Integer id;
    @JSONField(name="real_name")
    private String realName;
    private String remark;
    private String password;
    private String username;
}
