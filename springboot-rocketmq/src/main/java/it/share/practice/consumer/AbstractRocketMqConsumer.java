package it.share.practice.consumer;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.MessageListener;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;

/**
 * @author ：zhangyabo872
 * @description：TODO
 * @date ：2020/9/19 11:16
 */
public abstract class AbstractRocketMqConsumer {

    private DefaultMQPushConsumer consumer;

    public AbstractRocketMqConsumer(){
        consumer = new DefaultMQPushConsumer(getGroupName());
        consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);
        consumer.setInstanceName("A");
        consumer.setNamesrvAddr(getNameServer());
        try {
            consumer.subscribe(getTopicName(), getTagName());
        }catch (Exception e){
            e.printStackTrace();
        }
        consumer.registerMessageListener(getMsgListenre());
        try {
            consumer.start();
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

    /**
     * message listener
     * @return
     */
    protected abstract MessageListener getMsgListenre();
}
