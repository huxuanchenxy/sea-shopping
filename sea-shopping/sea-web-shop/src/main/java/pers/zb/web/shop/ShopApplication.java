package pers.zb.web.shop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @EnableDiscoveryClient 注解的作用：使得服务调用者，有能力去Eureka中发现服务；
 * @EnableFeignClients 注解的作用：提供负载均衡的能力，同时需要在pom.xml中引入spring-cloud-starter-feign依赖
 *
 * 关于feign的教程，可参考 http://blog.csdn.net/forezp/article/details/69808079
 */
@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
public class ShopApplication {
    public static void main(String[] args) {
        SpringApplication.run(ShopApplication.class,args);

        /**
         * 这样也可以启动springboot应用；
         *      其实SpringApplicationBuilder只是对SpringApplication的启动进行了封装而已；
         *      看源码就知道了，最终还是调用的SpringApplication.run方法；
         */
        //new SpringApplicationBuilder(ShopApplication.class).run(args);
    }
}
