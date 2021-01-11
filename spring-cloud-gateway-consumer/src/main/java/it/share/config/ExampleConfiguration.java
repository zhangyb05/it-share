package it.share.config;

import it.share.filter.CustomGlobalFilter;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author ：zhangyabo872
 * @description：TODO
 * @date ：2021/1/11 21:50
 */
@Configuration
public class ExampleConfiguration {

    @Bean
    public GlobalFilter customFilter(){
       return new CustomGlobalFilter();
    }
}
