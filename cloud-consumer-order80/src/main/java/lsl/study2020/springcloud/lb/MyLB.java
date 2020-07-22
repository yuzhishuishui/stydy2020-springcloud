package lsl.study2020.springcloud.lb;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Component
@Slf4j
public class MyLB implements ServiceLoadBalanced {

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    //获取当前访问次数并返回目标地址索引
    private int getCurrentAndNext(){
        int current;
        int next;
        for(;;){
            current = atomicInteger.get();
            next = current >= Integer.MAX_VALUE ? 1 : current + 1;
            if(atomicInteger.compareAndSet(current,next)){
                log.info("\n当前访问次数：\t"+atomicInteger);
                return next;
            }
        }
    }

    @Override
    public ServiceInstance getServiceInstance(List<ServiceInstance> instances) {
        int index = getCurrentAndNext() % instances.size();
        return instances.get(index);
    }
}
