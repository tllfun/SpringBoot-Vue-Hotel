package com.secqin.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.secqin.config.Result;
import com.secqin.entity.Orders;
import com.secqin.entity.Room;
import com.secqin.entity.User;
import com.secqin.mapper.RoomMapper;
import com.secqin.service.RoomService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class RoomServiceImpl extends ServiceImpl<RoomMapper, Room> implements RoomService {
    @Resource
    private RoomMapper mapper;

    private Room getNewRoomByID(Room room) {
        return mapper.selectById(room.getId());
    }
    private Room getNewRoomByRoom(Room room) {
        return mapper.selectOne(Wrappers.<Room>lambdaQuery().eq(Room::getRoom, room.getRoom()));
    }


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
    public Result queryID(Integer currentPage, Integer pageSize, Integer id) {
        Page<Room> page = mapper.selectPage(new Page<>(currentPage, pageSize), Wrappers.<Room>lambdaQuery().like(Room::getId, id));
        return Result.succes(page);
    }

    @Override
    public Result queryRoom(Integer currentPage, Integer pageSize, Integer roomID) {
        Page<Room> page = mapper.selectPage(new Page<>(currentPage, pageSize), Wrappers.<Room>lambdaQuery().like(Room::getRoom, roomID));
        return Result.succes(page);
    }

    @Override
    public Result queryType(Integer currentPage, Integer pageSize, Integer type) {
        Page<Room> page = mapper.selectPage(new Page<>(currentPage, pageSize), Wrappers.<Room>lambdaQuery().like(Room::getType, type));
        return Result.succes(page);
    }

    @Override
    public Result queryFloor(Integer currentPage, Integer pageSize, Integer floor) {
        Page<Room> page = mapper.selectPage(new Page<>(currentPage, pageSize), Wrappers.<Room>lambdaQuery().like(Room::getFloor, floor));
        return Result.succes(page);
    }

    @Override
    public Result insertRoom(Room room) {
        if (room.getId() != null) {
            return Result.error("-1", "新增房间失败，原因：ID不能自定义");
        } else {

            Room room1 = mapper.selectOne(Wrappers.<Room>lambdaQuery().eq(Room::getRoom, room.getRoom()));
            if (room1 != null) {
                return Result.error("-1", "新增房间号失败，原因:房间号已经存在");
            } else {
                mapper.insert(room);
                return Result.succes("新增房间成功", this.getNewRoomByRoom(room));
            }
        }
    }

    @Override
    public Result updateRoom(Room room) {
        Room roomSelectByID = mapper.selectById(room.getId());
        if (roomSelectByID == null) {
            return Result.error("-1", "房间ID不存在");
        } else {
            Room roomSelectByUsername = mapper.selectOne(Wrappers.<Room>lambdaQuery().eq(Room::getRoom, room.getRoom()));
            if (roomSelectByUsername == null) {
                mapper.updateById(room);
                return Result.succes(getNewRoomByID(room));
            } else {
                if (roomSelectByID.getId().equals(roomSelectByUsername.getId())) {
                    mapper.updateById(room);
                    return Result.succes(getNewRoomByID(room));
                } else {
                    return Result.error("-1", "更新失败 房间号已存在");
                }
            }
        }
    }

    @Override
    public Result deleteRoom(Room room) {
        Room room1 = mapper.selectOne(Wrappers.<Room>lambdaQuery().eq(Room::getId, room.getId()));
        if (room1 == null) {
            return Result.error("-1", "更新失败 房间号不存在");
        } else {
            mapper.deleteById(room.getId());
            return Result.succes("房间信息删除成功");
        }
    }

    @Override
    public Result queryAll(Integer currentPage, Integer pageSize, Integer type, Integer keyWord) {
        if (type == 1) { // 查询ID
            return this.queryID(currentPage, pageSize, keyWord);
        } else if (type == 2) { // 查询Type
            return this.queryType(currentPage, pageSize, keyWord);
        } else { // 查询floor
            return this.queryFloor(currentPage, pageSize, keyWord);
        }
    }
}
