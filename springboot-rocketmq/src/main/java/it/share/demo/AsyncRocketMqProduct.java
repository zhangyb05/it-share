package it.share.demo;

import it.share.constant.RocketMqConstant;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author ：zhangyabo872
 * @description：异步发送
 * @date ：2020/9/18 21:52
 */
public class AsyncRocketMqProduct {

    public static void main(String[] args) throws Exception {
        DefaultMQProducer producer = new DefaultMQProducer(RocketMqConstant.GROUP_NAME);
        producer.setNamesrvAddr(RocketMqConstant.NAME_SERVER);
        producer.setRetryTimesWhenSendAsyncFailed(0);
        producer.start();
        CountDownLatch count = new CountDownLatch(100);
        for(int i = 0; i < 100; i++){
            final int index = i;
            Message msg = new Message(RocketMqConstant.TOPIC_NAME, RocketMqConstant.TAG_NAME, "key" + i, ("Hello word" + i).getBytes(RocketMqConstant.CHARSET));
            producer.send(msg, new SendCallback() {
                @Override
                public void onSuccess(SendResult sendResult) {
                    System.out.printf("%-10d OK %s %n", index,
                            sendResult.getMsgId());
                    count.countDown();
                }
                @Override
                public void onException(Throwable e) {
                    System.out.printf("%-10d Exception %s %n", index, e);
                    e.printStackTrace();
                    count.countDown();
                }
            });
            TimeUnit.SECONDS.sleep(1);
        }
        count.await();
        System.out.println("end");
        producer.shutdown();
    }
}
