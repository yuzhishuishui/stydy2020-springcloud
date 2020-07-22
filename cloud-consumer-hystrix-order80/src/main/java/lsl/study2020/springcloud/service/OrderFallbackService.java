package lsl.study2020.springcloud.service;

import org.springframework.stereotype.Component;

@Component
public class OrderFallbackService implements OrderHystrixService {
    @Override
    public String getSuccess() {
        return "service breaker... fail";
    }

    @Override
    public String getTimeout() {
        return "service breaker... timeout";
    }
}
