package pers.zb.web.shop.controller;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * 服务调用者
 */
@Configuration
@RestController
public class ShopController {

    /**
     * RestTemplate主要用于调用REST服务，本身不具备调用分布式服务的能力；
     * 当RestTemplate被@LoadBalanced注解修饰后，RestTemplate就具备调用分布式服务的能力；
     *
     * LoadBalanced：实现负载均衡
     */
    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

    /**
     * 向前端提供一个访问地址；调用服务service，并返回结果
     * @return
     */
    @RequestMapping(value = "/router",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public String router(){
        RestTemplate restTemplate = getRestTemplate();

        /**
         * 注意这里的url参数，其中的 sea-service-user 是具体的服务名；
         *      具体配置请查看 \sea-service-user\src\main\resources\application.yml 中的 spring.application.name的配置项；
         * 也就是说，eureka服务调用，是通过服务名来调用的，并非 ip + port 的形式，其中的好处，我想都应该清楚了，毕竟域名ip与port都会可能发生变化的。
         */
        String result = restTemplate.getForObject("http://sea-service-user/person/1",String.class);
        return result;
    }
}
