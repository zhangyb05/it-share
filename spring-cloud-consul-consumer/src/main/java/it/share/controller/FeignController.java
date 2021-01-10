package it.share.controller;

import it.share.service.FeignService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author ：zhangyabo872
 * @description：TODO
 * @date ：2021/1/10 20:30
 */
@RestController
public class FeignController {

    @Resource
    private FeignService feignService;

    @GetMapping("/consumer/feign/getInvorkUrl")
    public String invorkProviderByRestTemp(){
        return feignService.serviceProvider();
    }
}
