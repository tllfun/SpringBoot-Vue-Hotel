package com.secqin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.secqin.config.Result;
import com.secqin.entity.User;

import java.util.Date;


public interface UserService extends IService<User> {
    Result getAll(Integer currentPage, Integer pageSize);
    Result updateByID(User user);
    Result insert(User user);
    Result deleteByID(User user);
    Result queryID(Integer currentPage, Integer pageSize, Integer id);
    Result queryUsername(Integer currentPage, Integer pageSize, String keyWord);
    Result queryRole(Integer currentPage, Integer pageSize, Integer keyWord);
    Result queryPhone(Integer currentPage, Integer pageSize, String keyWord);
    Result queryEmail(Integer currentPage, Integer pageSize, String keyWord);
    Result queryCond(Integer currentPage, Integer pageSize, Integer keyWord);
    Result queryRoom(Integer currentPage, Integer pageSize, Integer keyWord);
    Result queryInTime(Integer currentPage, Integer pageSize, Date keyWord);
    Result queryOutTime(Integer currentPage, Integer pageSize, Date keyWord);
    Result login(String username, String password);
    Result register(User user);
}
