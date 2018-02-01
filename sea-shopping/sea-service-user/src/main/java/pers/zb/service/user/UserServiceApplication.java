package pers.zb.service.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 *  【遇到的问题】：
 *      【问题描述】：一开始我将UserServiceApplication这个类直接创建于 /src/main/java 目录下，启动项目的时候会出现警告，最终会报错；
 *              警告信息如下：
 *                      ** WARNING ** : Your ApplicationContext is unlikely to start due to a @ComponentScan of the default package.
 *              异常信息如下：
 *              Could not evaluate condition on org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration$JdbcTemplateConfiguration due to internal class not found.
 *              This can happen if you are @ComponentScanning a springframework package (e.g. if you put a @ComponentScan in the default package by mistake)
 *      【解决办法】：
 *              从警告的内容上来看，简单来说，就是不能在 /src/main/java 目录下有启动类，应该放在自己的package下面，需要创建package；
 *
 *       参考文章：https://segmentfault.com/a/1190000004493460
 */
@EnableEurekaClient
@SpringBootApplication
public class UserServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserServiceApplication.class,args);

        /**
         * 这样也可以启动springboot应用；
         *      其实SpringApplicationBuilder只是对SpringApplication的启动进行了封装而已；
         *      看源码就知道了，最终还是调用的SpringApplication.run方法；
         */
        //new SpringApplicationBuilder(UserServiceApplication.class).run(args);
    }
}
