package it.share.consumer;

import com.alibaba.dubbo.config.annotation.Reference;
import it.share.service.IDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author ：zhangyabo872
 * @description：TODO
 * @date ：2020/12/25 20:53
 */
@Controller
@RequestMapping("/demoConsumer")
public class DemoConsumer {

    @Autowired
    private IDemoService demoService;

    public DemoConsumer(){
        System.out.println("---------------------------------------------------------dddddddddddddddddddddddddd");
    }
    @RequestMapping("/getResult")
    @ResponseBody
    public String getResult(){
        return demoService.sayName("word---");
    }
}
