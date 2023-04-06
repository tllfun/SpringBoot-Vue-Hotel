package com.secqin.controller;


import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.secqin.config.Result;
import com.secqin.entity.Room;
import com.secqin.mapper.RoomMapper;
import org.springframework.web.bind.annotation.*;

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

    @DeleteMapping("/delete/{id}")
    public Result<?> delete(@PathVariable Long id) {
        Result<Object> result = new Result<>();
        int flag = roomMapper.deleteById(id);
        if (flag == 0){
            return Result.error("1","删除错误");
        } else {
            result.setCode("0");
            result.setMsg("删除成功");
        }
        return result;
    }
}
