package it.share.service;

/**
 * @author ：zhangyabo872
 * @description：TODO
 * @date ：2020/10/4 20:50
 */
public class DemoServiceImpl implements IDemoService{
    @Override
    public String sayName(String name) {
        return "hello: " + name;
    }
}
