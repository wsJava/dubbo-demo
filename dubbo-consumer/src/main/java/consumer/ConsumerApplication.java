package consumer;

import lvjp.service.DemoService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class ConsumerApplication {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/dubbo-consumer.xml");
        context.start();

        DemoService demoService = context.getBean("demoService", DemoService.class);

        System.out.println(demoService.sayHello("world0"));

        CompletableFuture<String> hello = demoService.sayHellAsync("world");
        System.out.println("result: " + hello.get());
    }
}
