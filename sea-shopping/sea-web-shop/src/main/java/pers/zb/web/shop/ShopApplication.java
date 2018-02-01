package pers.zb.web.shop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @EnableDiscoveryClient 注解的作用：使得服务调用者，有能力去Eureka中发现服务；
 */
@EnableDiscoveryClient
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
