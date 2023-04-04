package com.secqin.controller;


import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.secqin.config.Result;
import com.secqin.entity.Room;
import com.secqin.mapper.RoomMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/room")
public class RoomController {
    @Resource
    RoomMapper roomMapper;

    @GetMapping("/list")
    public Result<?> getAll() {
        Page<Room> roomPage = roomMapper.selectPage(new Page<>(1, 10), Wrappers.<Room>lambdaQuery().ne(Room::getRoom, 0));
        return Result.succes(roomPage);
    }
}
