package it.share.controller;

import it.share.service.ProviderService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author ：zhangyabo872
 * @description：TODO
 * @date ：2021/1/10 10:30
 */
@RestController
public class ServiceController {
    @Resource
    private ProviderService providerService;

    @GetMapping("/provider/serviceProvider")
    public String serviceProvider(){
        return providerService.serviceProvider();
    }
}
