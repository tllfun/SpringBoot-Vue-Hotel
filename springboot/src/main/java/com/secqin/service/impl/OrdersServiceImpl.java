package com.secqin.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.secqin.entity.Orders;
import com.secqin.mapper.OrdersMapper;
import com.secqin.service.OrdersService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class OrdersServiceImpl extends ServiceImpl<OrdersMapper, Orders> implements OrdersService {
    @Resource
    private OrdersMapper ordersMapper;

    @Override
    public Page<Orders> Fuck(Integer userId) {
        return ordersMapper.selectPage(new Page<>(1, 100), Wrappers.<Orders>lambdaQuery().eq(Orders::getUserId, userId));
    }
}
