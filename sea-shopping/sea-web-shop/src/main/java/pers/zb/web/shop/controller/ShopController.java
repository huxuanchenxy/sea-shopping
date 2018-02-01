package pers.zb.web.shop.controller;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Configuration
@RestController
public class ShopController {

    /**
     * RestTemplate主要用于调用REST服务，本身不具备调用分布式服务的能力；
     * 当RestTemplate被@LoadBalanced注解修饰后，RestTemplate就具备调用分布式服务的能力；
     */
    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

    @RequestMapping(value = "/router",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public String router(){
        RestTemplate restTemplate = getRestTemplate();
        String result = restTemplate.getForObject("http://sea-service-user/person/1",String.class);
        return result;
    }
}
