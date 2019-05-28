# YUNPLUS-EUREKA
> 云加eureka注册中心

## 使用说明
配置机器`/etc/hosts` 例如:
```
172.16.1.155 eureka1
172.16.1.156 eureka2
```
启动的脚本中 在jar后面增加`--spring.profiles.active=eureka1` 
> ps.后面的eureka1 根据所在机器配置，例如机器是156，则配置为eureka2

## 多节点（2个以上）配置
- 扩增`resources`目录下的`application-eureka*.yml`文件
- 原来的配置文件，同步增加新的eureka地址，也可以`A->B->C->A`这样的链式注册

## 变动说明
- 增加apollo相关代码，提供给apollo配置中心注册