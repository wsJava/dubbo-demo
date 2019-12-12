package lvjp.service.impl;

import com.alibaba.dubbo.rpc.RpcContext;
import lvjp.service.DemoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CompletableFuture;

public class DemoServiceImpl implements DemoService {

    private static final Logger log = LoggerFactory.getLogger(DemoServiceImpl.class);

    public String sayHello(String name) {
        System.err.println("Hello " + name + ", request from consumer: " + RpcContext.getContext().getRemoteAddress());
        return "Hello " + name + ", response from provider: " + RpcContext.getContext().getLocalAddress();
    }

    @Override
    public CompletableFuture<String> sayHellAsync(String name) {
        CompletableFuture<String> cf = CompletableFuture.supplyAsync( () -> "async result");
        return cf;
    }
}
