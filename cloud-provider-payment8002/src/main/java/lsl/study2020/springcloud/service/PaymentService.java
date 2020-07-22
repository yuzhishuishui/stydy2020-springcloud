package lsl.study2020.springcloud.service;

import lsl.study2020.springcloud.entities.Payment;

import java.util.List;

public interface PaymentService {
    public int save(Payment payment);
    public Payment getPaymentById(Long id);
    public List<Payment> getAll();
    public int deleteById(Long id);
    public int updateById(Payment payment);
    public List<Payment> getPages(int page, int size);
}
