package it.share.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author ：zhangyabo872
 * @description：TODO
 * @date ：2021/1/10 10:22
 */
@RestController
public class RestTemController {

    private static String INVOR_URL = "http://spring-cloud-consul-provider/";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/rest/getInvorkUrl")
    public String invorkProviderByRestTemp(){
      return restTemplate.getForObject(INVOR_URL + "/provider/serviceProvider", String.class);
    }
}
