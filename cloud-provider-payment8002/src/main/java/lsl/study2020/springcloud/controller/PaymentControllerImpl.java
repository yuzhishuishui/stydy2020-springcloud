package lsl.study2020.springcloud.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import lsl.study2020.springcloud.entities.CommonResult;
import lsl.study2020.springcloud.entities.Payment;
import lsl.study2020.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payment")
@Slf4j //日志
@Api(tags = "payment接口")
public class PaymentControllerImpl implements PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Override
    @PostMapping("/save")
    @ApiOperation("保存单条数据")
    public CommonResult save(@RequestBody Payment payment) {
        int status = paymentService.save(payment);
        if(status > 0){
            return new CommonResult(200,"数据保存成功",status);
        }
        return new CommonResult(444,"数据保存失败");
    }

    @Override
    @GetMapping("/get/{id}")
    @ApiOperation("根据ID查询数据")
    public CommonResult getPaymentById(@PathVariable Long id) {
        Payment payment = paymentService.getPaymentById(id);
        if(null == payment){
            return new CommonResult(444,"未找到该条数据:"+id);
        }
        return new CommonResult(200,"找到一条数据,serverPort:"+serverPort,payment);
    }

    @Override
    @GetMapping("/getall")
    @ApiOperation("查询所有记录")
    public CommonResult getAll() {
        List<Payment> all = paymentService.getAll();
        if(all.size() < 1){
            return new CommonResult(444,"未找到任何数据");
        }
        return new CommonResult(200,"查询成功",all);
    }

    @Override
    @DeleteMapping("/delete/{id}")
    @ApiOperation("根据ID删除记录")
    public CommonResult deleteById(@PathVariable("id") Long id) {
        int res = paymentService.deleteById(id);
        if(res < 1){
            return new CommonResult(444,"删除失败,未找到该记录:"+id);
        }
        return new CommonResult(200,"删除成功",res);
    }

    @Override
    @PostMapping("/update")
    @ApiOperation("修改数据")
    public CommonResult updateById(@RequestBody Payment payment) {
        int res = paymentService.updateById(payment);
        if(res < 1){
            return new CommonResult(444,"修改数据失败,没有该条记录"+payment.getId());
        }
        return new CommonResult(200,"修改数据成功",res);
    }

    @Override
    @GetMapping("/gets/{page}/{size}")
    @ApiOperation("分页查询数据")
    public CommonResult getPages(@PathVariable("page") int page,@PathVariable("size") int size) {
        if(page<1){
            page = 1;
        }
        if(size<1){
            size = 2;
        }
        List<Payment> pages = paymentService.getPages((page-1)*size, size);
        if(pages.size() < 1){
            return new CommonResult(444,"未找到任何数据");
        }
        return new CommonResult(200,"查询成功",pages);
    }

    @GetMapping("/getlb")
    public String getLB(){
        return serverPort;
    }
}
