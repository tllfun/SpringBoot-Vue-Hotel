package com.secqin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.secqin.config.Result;
import com.secqin.entity.Room;
import com.secqin.entity.User;

import java.util.Date;

public interface RoomService extends IService<Room> {
    Result getAll(Integer currentPage, Integer pageSize);
    Result insertRoom(Room room);
    Result updateRoom(Room room);
    Result deleteRoom(Room room);
    Result queryAllAvailable(Integer currentPage, Integer pageSize);
    Result queryID(Integer currentPage, Integer pageSize, Integer id);
    Result queryRoom(Integer currentPage, Integer pageSize, Integer roomID);
    Result queryType(Integer currentPage, Integer pageSize, Integer type);
    Result queryFloor(Integer currentPage, Integer pageSize, Integer floor);
    Result queryAll(Integer currentPage, Integer pageSize, Integer type, Integer keyWord);
}
