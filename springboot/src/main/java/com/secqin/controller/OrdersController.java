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
import java.util.Date;

@RestController
@RequestMapping("/orders")
public class OrdersController {
    @Resource
    private OrdersService service;

    @GetMapping("/list")
    public Result<?> getAll() {
        return service.getAll();
    }
    @PostMapping("/insert")
    public Result<?> insert(@RequestBody Orders order) {
        return service.insert(order);
    }

    @PutMapping("/update")
    public Result<?> update(@RequestBody Orders order) {
        return service.updateByID(order);
    }

    @DeleteMapping("/delete/{id}")
    public Result<?> delete(@PathVariable Integer id) {
        return service.deleteByID(id);
    }

    @GetMapping("query/id/{id}")
    public Result<?> queryID(@PathVariable Integer id) {
        return service.queryID(id);
    }

    @GetMapping("/query/userid")
    public Result<?> queryUserId(@RequestParam(defaultValue = "1") Integer currentPage,
                                 @RequestParam(defaultValue = "10") Integer pageSize,
                                 @RequestParam(defaultValue = "") Integer keyWord) {
        return service.queryUserID(currentPage, pageSize, keyWord);
    }

    @GetMapping("/query/managerid")
    public Result<?> queryManagerID(@RequestParam(defaultValue = "1") Integer currentPage,
                                    @RequestParam(defaultValue = "10") Integer pageSize,
                                    @RequestParam(defaultValue = "") Integer keyWord) {
        return service.queryManagerID(currentPage, pageSize, keyWord);
    }

    @GetMapping("/query/room")
    public Result<?> queryRoom(@RequestParam(defaultValue = "1") Integer currentPage,
                               @RequestParam(defaultValue = "10") Integer pageSize,
                               @RequestParam(defaultValue = "") Integer keyWord) {
        return service.queryRoom(currentPage, pageSize, keyWord);
    }

    @GetMapping("/query/inTime")
    public Result<?> queryInTime(@RequestParam(defaultValue = "1") Integer currentPage,
                                 @RequestParam(defaultValue = "10") Integer pageSize,
                                 @RequestParam(defaultValue = "") Date keyWord) {
        return service.queryInTime(currentPage, pageSize, keyWord);
    }

    @GetMapping("/query/outTime")
    public Result<?> queryOutTime(@RequestParam(defaultValue = "1") Integer currentPage,
                                  @RequestParam(defaultValue = "10") Integer pageSize,
                                  @RequestParam(defaultValue = "") Date keyWord) {
        return service.queryOutTime(currentPage, pageSize, keyWord);
    }
}
