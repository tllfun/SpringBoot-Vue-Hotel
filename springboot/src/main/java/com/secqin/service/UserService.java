package com.secqin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.secqin.config.Result;
import com.secqin.entity.User;

import java.util.Date;


public interface UserService extends IService<User> {
    Result getAll();
    Result updateByID(User user);
    Result insert(User user);
    Result deleteByID(Integer id);
    Result queryID(Integer id);
    Result queryUsername(Integer currentPage, Integer pageSize, String keyWord);
    Result queryPassword(Integer currentPage, Integer pageSize, String keyWord);
    Result queryRole(Integer currentPage, Integer pageSize, Integer keyWord);
    Result queryPhone(Integer currentPage, Integer pageSize, String keyWord);
    Result queryEmail(Integer currentPage, Integer pageSize, String keyWord);
    Result queryCond(Integer currentPage, Integer pageSize, Integer keyWord);
    Result queryRoom(Integer currentPage, Integer pageSize, Integer keyWord);
    Result queryInTime(Integer currentPage, Integer pageSize, Date keyWord);
    Result queryOutTime(Integer currentPage, Integer pageSize, Date keyWord);
}
