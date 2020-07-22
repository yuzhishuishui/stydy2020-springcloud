package lsl.study2020.springcloud.service;

import lsl.study2020.springcloud.dao.PaymentDao;
import lsl.study2020.springcloud.entities.Payment;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    PaymentDao paymentDao;

    @Override
    public int save(Payment payment) {
        return paymentDao.save(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }

    @Override
    public List<Payment> getAll() {
        return paymentDao.getAll();
    }

    @Override
    public int deleteById(Long id) {
        return paymentDao.deleteById(id);
    }

    @Override
    public int updateById(Payment payment) {
        return paymentDao.updateById(payment);
    }

    @Override
    public List<Payment> getPages(int page, int size) {
        return paymentDao.getPages(page, size);
    }
}
