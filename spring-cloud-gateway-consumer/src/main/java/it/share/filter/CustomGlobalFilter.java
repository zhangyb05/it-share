package it.share.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @author ：zhangyabo872
 * @description：TODO
 * @date ：2021/1/11 21:51
 */

public class CustomGlobalFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        System.out.println("CustomGlobalFilter.filter-------------------------------------");
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
