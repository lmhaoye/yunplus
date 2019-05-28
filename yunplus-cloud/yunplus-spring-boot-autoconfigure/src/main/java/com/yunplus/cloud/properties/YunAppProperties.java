package com.yunplus.cloud.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author forest.luo
 * @descripter 系统初始化配置属性说明，加载yunplus开头的数据
 */
@ConfigurationProperties("yunplus")
@Setter
@Getter
public class YunAppProperties {
    /**
     * 系统模块ID（由运维分配）
     */
    private String id;
}
