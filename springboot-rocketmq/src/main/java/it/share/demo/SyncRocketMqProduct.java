package it.share.demo;

import it.share.constant.RocketMqConstant;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;

/**
 * @author ：zhangyabo872
 * @description：同步发送rocketMa
 * @date ：2020/9/18 21:22
 */
public class SyncRocketMqProduct {

    public static void main(String[] args) throws Exception {
        DefaultMQProducer producer = new DefaultMQProducer(RocketMqConstant.GROUP_NAME);
        producer.setNamesrvAddr(RocketMqConstant.NAME_SERVER);
        producer.setRetryTimesWhenSendAsyncFailed(0);
        producer.start();
        for(int i = 0; i < 100; i++){
            Message msg = new Message(RocketMqConstant.TOPIC_NAME, RocketMqConstant.TAG_NAME, "key" + i, ("Hello word" + i).getBytes(RocketMqConstant.CHARSET));
            SendResult sendResult = producer.send(msg);
            System.out.println("send request:" + sendResult);
        }
        producer.shutdown();
    }
}
