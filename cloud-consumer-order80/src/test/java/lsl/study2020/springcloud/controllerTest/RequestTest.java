package lsl.study2020.springcloud.controllerTest;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@SpringBootTest
public class RequestTest {

    @Resource
    RestTemplate restTemplate;
    //测试多次请求
    @Test
    public void connectTest(){
        int max = Integer.MAX_VALUE;
        String url = "http://localhost:80/consumer/payment/getlb";
        for (int i = 0;i < 3;i++){
            System.out.println(restTemplate.getForObject(url, String.class));
        }
    }
}
