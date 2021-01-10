package it.share.loadbalance;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.rpc.Invocation;
import com.alibaba.dubbo.rpc.Invoker;
import com.alibaba.dubbo.rpc.cluster.loadbalance.AbstractLoadBalance;
import com.alibaba.dubbo.rpc.cluster.loadbalance.RandomLoadBalance;
import com.fasterxml.jackson.databind.JsonSerializable;
import com.fasterxml.jackson.databind.util.JSONPObject;
import jdk.nashorn.internal.parser.JSONParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：zhangyabo872
 * @description：TODO
 * @date ：2020/12/25 20:48
 */
public class LocalPriorLoadBalance extends AbstractLoadBalance {
    private final static Logger logger = LoggerFactory.getLogger(LocalPriorLoadBalance.class);

    @Override
    protected <T> Invoker<T> doSelect(List<Invoker<T>> invokers, URL url, Invocation invocation) {
        logger.info("LocalPriorLoadBalance.doSelect:" + url.getHost());
        System.out.println("---------------------doSelect-----------");
        try {
            throw new Exception();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new RandomLoadBalance().select(new ArrayList<>(), url, invocation);
    }
}
