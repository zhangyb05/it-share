package it.share.config;

import com.alibaba.dubbo.config.ConsumerConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author ：zhangyabo872
 * @description：TODO
 * @date ：2020/12/25 20:44
 */
@Configuration
public class SelfConsumerConfig {

    /*@Bean
    public ConsumerConfig initConsumerConfig(){
        ConsumerConfig config = new ConsumerConfig();
        config.setCheck(false);
        config.setTimeout(20000);
        config.setLoadbalance("localPriorLoadBalance");
        return config;
    }*/
}
