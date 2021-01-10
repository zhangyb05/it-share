package it.share;

import it.share.service.IDemoService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * @author ：zhangyabo872
 * @description：TODO
 * @date ：2020/10/4 21:08
 */
@SpringBootApplication
@ImportResource(locations = {"classpath:consumer.xml"})
public class ApplicationRun {

   /* public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("consumer.xml");
        context.start();
        IDemoService demoService = context.getBean("demoService", IDemoService.class);
        System.out.println(demoService.sayName("word"));
        System.in.read();
    }*/
   public static void main(String[] args) {
       SpringApplication.run(ApplicationRun.class, args);
   }
}
