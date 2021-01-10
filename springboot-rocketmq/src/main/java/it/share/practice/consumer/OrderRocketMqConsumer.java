package it.share.practice.consumer;

import it.share.constant.RocketMqConstant;
import org.apache.rocketmq.client.consumer.listener.MessageListener;

/**
 * @author ：zhangyabo872
 * @description：TODO
 * @date ：2020/9/19 11:36
 */
public class OrderRocketMqConsumer extends AbstractRocketMqConsumer{
    @Override
    protected String getNameServer() {
        return RocketMqConstant.NAME_SERVER;
    }

    @Override
    protected String getGroupName() {
        return RocketMqConstant.GROUP_NAME;
    }

    @Override
    protected String getTopicName() {
        return RocketMqConstant.TOPIC_NAME;
    }

    @Override
    protected String getTagName() {
        return RocketMqConstant.TAG_NAME;
    }

    @Override
    protected MessageListener getMsgListenre() {
        return new OrderMessageListener();
    }
}
