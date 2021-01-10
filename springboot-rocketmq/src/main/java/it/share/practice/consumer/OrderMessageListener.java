package it.share.practice.consumer;

import org.apache.rocketmq.client.consumer.listener.ConsumeOrderlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeOrderlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerOrderly;
import org.apache.rocketmq.common.message.MessageExt;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author ：zhangyabo872
 * @description：TODO
 * @date ：2020/9/19 11:35
 */
public class OrderMessageListener implements MessageListenerOrderly {
    @Override
    public ConsumeOrderlyStatus consumeMessage(List<MessageExt> list, ConsumeOrderlyContext context) {
        Random random = new Random();
        context.setAutoCommit(true);
        for (MessageExt msg : list) {
            // 可以看到每个queue有唯一的consume线程来消费, 订单对每个queue(分区)有序
            System.out.println("consumeThread=" + Thread.currentThread().getName() + "queueId=" + msg.getQueueId() + ", content:" + new String(msg.getBody()));
        }

        try {
            //模拟业务逻辑处理中...
            TimeUnit.SECONDS.sleep(random.nextInt(10));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ConsumeOrderlyStatus.SUCCESS;
    }
}
