package lsl.study2020.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

public interface ServiceLoadBalanced {
    ServiceInstance getServiceInstance(List<ServiceInstance> instances);
}
