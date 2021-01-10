package it.share.demo;

import it.share.constant.RocketMqConstant;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.message.Message;

/**
 * @author ：zhangyabo872
 * @description：TODO
 * @date ：2020/9/18 22:52
 */
public class OnewayProducer {
    public static void main(String[] args)throws Exception {
        DefaultMQProducer producer = new DefaultMQProducer(RocketMqConstant.GROUP_NAME);
        producer.setNamesrvAddr(RocketMqConstant.NAME_SERVER);
        producer.start();
        for(int i = 0; i < 100; i++){
            Message msg = new Message(RocketMqConstant.TOPIC_NAME, RocketMqConstant.TAG_NAME, "key:" + i, ("Hello Word:" + i).getBytes(RocketMqConstant.CHARSET));
            producer.sendOneway(msg);
        }
        producer.shutdown();
    }
}
