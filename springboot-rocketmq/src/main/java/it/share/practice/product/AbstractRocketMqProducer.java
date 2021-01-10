package it.share.practice.product;

import org.apache.rocketmq.client.producer.DefaultMQProducer;

import javax.annotation.PostConstruct;

/**
 * @author ：zhangyabo872
 * @description：TODO
 * @date ：2020/9/19 10:49
 */
public abstract class AbstractRocketMqProducer {
    protected DefaultMQProducer producer;
    public AbstractRocketMqProducer(){
        System.out.println("------------------");
        producer = new DefaultMQProducer(getGroupName());
        producer.setNamesrvAddr(getNameServer());
        try{
            producer.start();
        }catch (Exception e){
            e.printStackTrace();
        }
    }





    /**
     * name Server
     * @return
     */
    protected abstract String getNameServer();
    /**
     * 组名称
     * @return
     */
    protected abstract String getGroupName();

    /**
     * topic name
     * @return
     */
    protected abstract String getTopicName();

    /**
     * tag name
     * @return
     */
    protected abstract String getTagName();
}
