package com.secqin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.secqin.config.Result;
import com.secqin.entity.Room;
import com.secqin.entity.User;

import java.util.Date;

public interface RoomService extends IService<Room> {
    Result getAll(Integer currentPage, Integer pageSize);
    Result queryAllAvailable(Integer currentPage, Integer pageSize);
    Result queryRoom(Integer roomID);
    Result queryType(Integer currentPage, Integer pageSize);
    Result queryFloor(Integer currentPage, Integer pageSize);
}
