package com.secqin.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.secqin.config.Result;
import com.secqin.entity.Room;
import com.secqin.mapper.RoomMapper;
import com.secqin.service.RoomService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class RoomServiceImpl extends ServiceImpl<RoomMapper, Room> implements RoomService {
    @Resource
    private RoomMapper mapper;

    @Override
    public Result getAll(Integer currentPage, Integer pageSize) {
        Page<Room> page = mapper.selectPage(new Page<>(currentPage, pageSize), Wrappers.<Room>lambdaQuery().ne(Room::getId, 0));
        return Result.succes(page);
    }

    @Override
    public Result queryAllAvailable(Integer currentPage, Integer pageSize) {
        Page<Room> page = mapper.selectPage(new Page<>(currentPage, pageSize), Wrappers.<Room>lambdaQuery().eq(Room::getAvailable, 1));
        return Result.succes(page);
    }

    @Override
    public Result queryRoom(Integer roomID) {
        Page<Room> page = mapper.selectPage(new Page<>(1, 1), Wrappers.<Room>lambdaQuery().ne(Room::getRoom, roomID));
        return Result.succes(page);
    }

    @Override
    public Result queryType(Integer currentPage, Integer pageSize) {
        Page<Room> page = mapper.selectPage(new Page<>(currentPage, pageSize), Wrappers.<Room>lambdaQuery().ne(Room::getType, 0));
        return Result.succes(page);
    }

    @Override
    public Result queryFloor(Integer currentPage, Integer pageSize) {
        Page<Room> page = mapper.selectPage(new Page<>(currentPage, pageSize), Wrappers.<Room>lambdaQuery().ne(Room::getFloor, 0));
        return Result.succes(page);
    }
}
