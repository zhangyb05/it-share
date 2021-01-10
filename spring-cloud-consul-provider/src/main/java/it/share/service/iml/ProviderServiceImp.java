package it.share.service.iml;

import com.google.gson.JsonObject;
import it.share.service.ProviderService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：zhangyabo872
 * @description：TODO
 * @date ：2021/1/10 10:32
 */
@Service
public class ProviderServiceImp implements ProviderService {

    @Value(value = "${server.port}")
    public String servicePort;

    @Override
    public String serviceProvider() {
        Map<String, String> resultMap = new HashMap<>(8);
        resultMap.put("code", "200");
        resultMap.put("port", servicePort);
        resultMap.put("msg", "success");
        return resultMap.toString();
    }
}
