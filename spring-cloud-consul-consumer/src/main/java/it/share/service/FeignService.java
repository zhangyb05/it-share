package it.share.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author ：zhangyabo872
 * @description：TODO
 * @date ：2021/1/10 20:32
 */
@FeignClient("spring-cloud-consul-provider")
public interface FeignService {
    @GetMapping("/provider/serviceProvider")
    String serviceProvider();
}
