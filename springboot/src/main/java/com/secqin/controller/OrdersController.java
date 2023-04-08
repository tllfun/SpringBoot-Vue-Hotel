package com.secqin.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.secqin.config.Result;
import com.secqin.entity.Orders;
import com.secqin.mapper.OrdersMapper;
import com.secqin.service.OrdersService;
import com.secqin.service.impl.OrdersServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/orders")
public class OrdersController {
    @Resource
    private OrdersMapper ordersMapper;

//    @Autowired
//    private OrdersServiceImpl ordersService;

    private Page<Orders> getPage(Integer id) {
        return ordersMapper.selectPage(new Page<>(1, 1), Wrappers.<Orders>lambdaQuery().eq(Orders::getId, id));
    }

    @GetMapping("/list")
    public Result<?> getAll() {
        Page<Orders> orderPage = ordersMapper.selectPage(new Page<>(1, 10), Wrappers.<Orders>lambdaQuery().ne(Orders::getId, 0));
        return Result.succes(orderPage);
    }

    @GetMapping("/query/userid")
    public Result<?> queryUserId(@RequestParam(defaultValue = "0") Integer userId) {
        Page<Orders> ordersPage = ordersMapper.selectPage(new Page<>(1, 10), Wrappers.<Orders>lambdaQuery().eq(Orders::getUserId, userId));
        return Result.succes(ordersPage);
    }
//    @GetMapping("/query/userid")
//    public Result<?> queryUserId(@RequestParam(defaultValue = "1") Integer userId) {
//        return Result.succes(ordersService.Fuck(userId));
//    }

    @PostMapping("/insert")
    public Result<?> insert(@RequestBody Orders order) {
        ordersMapper.insert(order);
        Page<Orders> ordersPage = ordersMapper.selectPage(new Page<>(1, 1), Wrappers.<Orders>lambdaQuery().orderByDesc(Orders::getId));
        return Result.succes(ordersPage);
    }

    @PutMapping("/update")
    public Result<?> update(@RequestBody Orders order) {
        ordersMapper.updateById(order);
        return Result.succes(getPage(order.getId()));
    }

    @DeleteMapping("/delete")
    public Result<?> delete(@RequestBody Orders order) {
        ordersMapper.deleteById(order.getId());
        return Result.succes();
    }
}
