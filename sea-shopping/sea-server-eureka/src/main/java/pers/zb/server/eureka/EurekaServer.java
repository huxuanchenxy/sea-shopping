package pers.zb.server.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class EurekaServer {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServer.class,args);

        /**
         * 这样也可以启动springboot应用；
         *      其实SpringApplicationBuilder只是对SpringApplication的启动进行了封装而已；
         *      看源码就知道了，最终还是调用的SpringApplication.run方法；
         */
        //new SpringApplicationBuilder(EurekaServer.class).run(args);
    }
}
