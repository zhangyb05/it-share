package it.share;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author ：zhangyabo872
 * @description：TODO
 * @date ：2021/1/9 22:17
 */
@SpringBootApplication
//@EnableDiscoveryClient
@EnableFeignClients
public class ApplicationRun {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationRun.class, args);
    }
}
