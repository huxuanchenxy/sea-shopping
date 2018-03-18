package pers.zb.web.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pers.zb.web.shop.service.UserServiceFeign;

/**
 * 服务调用者
 */
@RestController
public class ShopController {

    @Autowired
    private UserServiceFeign userServiceFeign;

    /**
     * 向前端提供一个访问地址；通过userServiceFeign调用服务并返回结果
     * @return
     */
    @RequestMapping(value = "/router",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public String router(){
        String result = userServiceFeign.getUser();
        return result;
    }
}
