package com.secqin.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.secqin.config.Result;
import com.secqin.entity.Orders;
import com.secqin.entity.User;
import com.secqin.mapper.OrdersMapper;
import com.secqin.service.OrdersService;
import com.sun.org.apache.xpath.internal.operations.Or;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

@Service
public class OrdersServiceImpl extends ServiceImpl<OrdersMapper, Orders> implements OrdersService {
    @Resource
    private OrdersMapper mapper;

    private Orders getNewUserByID(Orders orders) {
        return mapper.selectById(orders.getId());
    }

    @Override
    public Result getAll(Integer currentPage, Integer pageSize) {
        Page<Orders> page = mapper.selectPage(new Page<>(currentPage, pageSize), Wrappers.<Orders>lambdaQuery().ne(Orders::getId, 0));
        return Result.succes(page);
    }

    @Override
    public Result updateByID(Orders orders) {
        Orders orders1 = mapper.selectOne(Wrappers.<Orders>lambdaQuery().eq(Orders::getId, orders.getId()));
        if (orders1 == null) {
            return Result.error("-1", "订单不存在");
        } else {
            mapper.updateById(orders);
            return Result.succes("订单信息更新成功", this.getNewUserByID(orders));
        }
    }

    @Override
    public Result insert(Orders orders) {
        if (orders.getId() != null) {
            return Result.error("-1", "订单添加失败，原因：ID不能自定义");
        } else {
            mapper.insert(orders);
            return Result.succes("订单添加成功", this.getNewUserByID(orders));
        }
    }

    @Override
    public Result deleteByID(Orders orders) {
        Orders orders1 = mapper.selectOne(Wrappers.<Orders>lambdaQuery().eq(Orders::getId, orders.getId()));
        if (orders == null) {
            return Result.error("-1", "订单不存在");
        } else {
            mapper.deleteById(orders.getId());
            return Result.succes("订单删除成功");
        }
    }

    @Override
    public Result queryID(Integer currentPage, Integer pageSize, Integer id) {
        Page<Orders> page = mapper.selectPage(new Page<>(currentPage, pageSize), Wrappers.<Orders>lambdaQuery().like(Orders::getId, id));
        return Result.succes(page);
    }

    @Override
    public Result queryUserID(Integer currentPage, Integer pageSize, Integer keyWord) {
        Page<Orders> page = mapper.selectPage(new Page<>(currentPage, pageSize), Wrappers.<Orders>lambdaQuery().like(Orders::getUserId, keyWord));
        return Result.succes(page);
    }

    @Override
    public Result queryManagerID(Integer currentPage, Integer pageSize, Integer keyWord) {
        Page<Orders> page = mapper.selectPage(new Page<>(currentPage, pageSize), Wrappers.<Orders>lambdaQuery().like(Orders::getManagerId, keyWord));
        return Result.succes(page);
    }

    @Override
    public Result queryRoom(Integer currentPage, Integer pageSize, Integer keyWord) {
        Page<Orders> page = mapper.selectPage(new Page<>(currentPage, pageSize), Wrappers.<Orders>lambdaQuery().like(Orders::getRoom, keyWord));
        return Result.succes(page);
    }

    @Override
    public Result queryInTime(Integer currentPage, Integer pageSize, String keyWord) {
        Page<Orders> page = mapper.selectPage(new Page<>(currentPage, pageSize), Wrappers.<Orders>lambdaQuery().like(Orders::getInTime, keyWord));
        return Result.succes(page);
    }

    @Override
    public Result queryOutTime(Integer currentPage, Integer pageSize, String keyWord) {
        Page<Orders> page = mapper.selectPage(new Page<>(currentPage, pageSize), Wrappers.<Orders>lambdaQuery().like(Orders::getOutTime, keyWord));
        return Result.succes(page);
    }
}
