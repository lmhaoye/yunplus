package com.yunplus.cloud.autoconfigure;

import com.yunplus.cloud.base.exception.ErrorCode;
import com.yunplus.cloud.exception.YunAppException;
import com.yunplus.cloud.properties.YunAppProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * @author forest.luo
 */
@Configuration
@EnableConfigurationProperties(YunAppProperties.class)
public class YunAppAutoConfiguration {
    @Autowired
    private YunAppProperties properties;

    @PostConstruct
    public void init() {
        String appId = properties.getId();
        if (appId == null || "".equals(appId)) {
            throw new YunAppException("未定义模块ID");
        }
        ErrorCode.init(appId);
    }
}
