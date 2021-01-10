package it.share.service.run;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * @author ：zhangyabo872
 * @description：TODO
 * @date ：2020/10/4 21:43
 */
public class ApplicationRun {

    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("provider.xml");
        context.start();
        System.in.read();
    }
}
