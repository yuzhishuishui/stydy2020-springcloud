package lsl.study2020.springcloud.controller;

import lsl.study2020.springcloud.entities.CommonResult;
import lsl.study2020.springcloud.entities.Payment;

public interface PaymentController {
    public CommonResult save(Payment payment);
    public CommonResult getPaymentById(Long id);
    public CommonResult getAll();
    public CommonResult deleteById(Long id);
    public CommonResult updateById(Payment payment);
    public CommonResult getPages(int page, int size);
    public Object discovery();
}
