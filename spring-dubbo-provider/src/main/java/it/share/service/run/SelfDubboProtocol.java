package it.share.service.run;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.rpc.Exporter;
import com.alibaba.dubbo.rpc.Invoker;
import com.alibaba.dubbo.rpc.RpcException;
import com.alibaba.dubbo.rpc.protocol.AbstractProtocol;
import com.alibaba.dubbo.rpc.protocol.dubbo.DubboProtocol;

/**
 * @author ：zhangyabo872
 * @description：TODO
 * @date ：2020/12/23 22:02
 */
public class SelfDubboProtocol extends AbstractProtocol {


    @Override
    public int getDefaultPort() {
        return DubboProtocol.getDubboProtocol().getDefaultPort();
    }

    @Override
    public <T> Exporter<T> export(Invoker<T> invoker) throws RpcException {
        return DubboProtocol.getDubboProtocol().export(invoker);
    }

    @Override
    public <T> Invoker<T> refer(Class<T> type, URL url) throws RpcException {
        return DubboProtocol.getDubboProtocol().refer(type, url.addParameterIfAbsent("envTag", "ft"));

    }


}
