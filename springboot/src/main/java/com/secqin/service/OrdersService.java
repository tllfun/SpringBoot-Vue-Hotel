package com.secqin.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.secqin.config.Result;
import com.secqin.entity.Orders;
import com.secqin.entity.User;

import java.util.Date;

public interface OrdersService extends IService<Orders> {
    Result getAll();
    Result updateByID(Orders orders);
    Result insert(Orders orders);
    Result deleteByID(Integer id);
    Result queryID(Integer id);
    Result queryUserID(Integer currentPage, Integer pageSize, Integer keyWord);
    Result queryManagerID(Integer currentPage, Integer pageSize, Integer keyWord);
    Result queryRoom(Integer currentPage, Integer pageSize, Integer keyWord);
    Result queryInTime(Integer currentPage, Integer pageSize, Date keyWord);
    Result queryOutTime(Integer currentPage, Integer pageSize, Date keyWord);
}
