package it.share.practice.product;

import it.share.constant.RocketMqConstant;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.apache.rocketmq.remoting.exception.RemotingException;

/**
 * @author ：zhangyabo872
 * @description：TODO
 * @date ：2020/9/19 11:01
 */
public class OneWayProduct extends AbstractRocketMqProducer {


    public void sendOneWay(String body) throws Exception  {
        Message msg = new Message(this.getTopicName(), this.getTagName(),"keys", body.getBytes(RemotingHelper.DEFAULT_CHARSET));
        producer.sendOneway(msg);
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
