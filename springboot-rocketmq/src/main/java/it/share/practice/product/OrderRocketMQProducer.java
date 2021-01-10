package it.share.practice.product;

import it.share.constant.RocketMqConstant;
import org.apache.rocketmq.client.producer.MessageQueueSelector;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageQueue;
import org.apache.rocketmq.remoting.common.RemotingHelper;

import java.util.List;

/**
 * @author ：zhangyabo872
 * @description：TODO
 * @date ：2020/9/19 11:08
 */
public class OrderRocketMQProducer extends AbstractRocketMqProducer {

    public SendResult sendOrder(String body, Long key) throws Exception{
        Message msg = new Message(getTopicName(), getTagName(), "keys", body.getBytes(RemotingHelper.DEFAULT_CHARSET));
       return producer.send(msg, new MessageQueueSelector() {
            @Override
            public MessageQueue select(List<MessageQueue> list, Message message, Object o) {
                Long id = (Long)o;
                long index = id % list.size();
                return list.get((int)index);
            }
        }, key);
    }
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
}
