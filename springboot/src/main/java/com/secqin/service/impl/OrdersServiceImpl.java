package com.secqin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.secqin.entity.Orders;
import com.secqin.mapper.OrdersMapper;
import com.secqin.service.OrdersService;
import org.springframework.stereotype.Service;

@Service
public class OrdersServiceImpl extends ServiceImpl<OrdersMapper, Orders> implements OrdersService {
}
