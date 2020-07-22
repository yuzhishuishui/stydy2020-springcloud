package lsl.study2020.springcloud.dao;

import lsl.study2020.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PaymentDao {
    /**
     * 增
     * @param payment 实体
     * @return 插入状态
     */
    public int save(Payment payment);

    /**
     * 删
     * @param id 主键
     * @return 状态
     */
    public int deleteById(@Param("id") Long id);

    /**
     * 改
     * @param id 主键
     * @return 状态
     */
    public int updateById(Payment payment);

    /**
     * 查
     * @param id 主键
     * @return 返回数据
     */
    //根据ID查
    public Payment getPaymentById(@Param("id") Long id);
    //查询所有
    public List<Payment> getAll();
    //分页查 分页从0开始
    public List<Payment> getPages(@Param("page") int page, @Param("size") int size);
}
