# bms-demo
## 《spring cloud微服务实战 翟永超》
> springcloud工程架构搭建
###### bms-demo-eureka
> eureka注册中心 eureka server, security
###### bms-demo-test
> 提供服务 eureka client, sleuth, logstash, zipkin
###### bms-demo-test2
> 消费服务 eureka client, ribbon, hystrix, hystrix dashboard, actuator
###### bms-demo-test3
> turbine, actuator
###### bms-demo-test4
> turbine stream 未完成(需要rabbitmq)
###### bms-demo-test5
> feign, eureka client
###### bms-demo-zuul
> zuul, eureka client
###### bms-demo-config
> config配置中心 config server, security, eureka client
###### bms-demo-test6
> config client, eureka client, retry, aop, actuator
###### bms-demo-test7 (todo)
> bus rabbitmq
###### bms-demo-test8
> 链路跟踪 sleuth, logstash, zipkin, ribbon, eureka client
###### bms-demo-zipkin
> zipkin server

# 未完成
- hystrix dashboard监控页面 ping
- turbine监控页面
- feign dto复用
- config的加密解密，下载oracle的jar包
- config无法获取新的数据
- zipkin通过mq收集,zipkin数据持久化mysql

###### bms-demo-admin
> admin监控中心 admin server, eureka client, security, mail
###### bms-demo-test9
> admin client, eureka client, actuator