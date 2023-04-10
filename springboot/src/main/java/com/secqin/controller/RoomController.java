package com.secqin.controller;


import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.secqin.config.Result;
import com.secqin.entity.Room;
import com.secqin.mapper.RoomMapper;
import com.secqin.service.RoomService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/room")
public class RoomController {
    @Resource
    private RoomService service;

    @GetMapping("/list")
    public Result<?> list(@RequestParam(defaultValue = "1") Integer currentPage,
                          @RequestParam(defaultValue = "-1") Integer pageSize) {
        return service.getAll(currentPage, pageSize);
    }

    @PostMapping("/insert")
    public Result<?> insert(@RequestBody Room room) {
        return service.insertRoom(room);
    }

    @PutMapping("/update")
    public Result<?> update(@RequestBody Room room) { return service.updateRoom(room); }

    @DeleteMapping("/delete")
    public Result<?> delete(@RequestBody Room room) {
        return service.deleteRoom(room);
    }

    @GetMapping("/query/available")
    public Result<?> queryAvailable(@RequestParam(defaultValue = "1") Integer currentPage,
                                    @RequestParam(defaultValue = "-1") Integer pageSize) {
        return service.queryAllAvailable(currentPage, pageSize);
    }

    @GetMapping("query/id")
    public Result<?> queryID(@RequestParam(defaultValue = "1") Integer currentPage,
                             @RequestParam(defaultValue = "-1") Integer pageSize,
                             @RequestParam(defaultValue = "") Integer id) {
        return service.queryID(currentPage, pageSize, id);
    }

    @GetMapping("query/room")
    public Result<?> queryRoom(@RequestParam(defaultValue = "1") Integer currentPage,
                               @RequestParam(defaultValue = "-1") Integer pageSize,
                               @RequestParam(defaultValue = "") Integer room) {
        return service.queryRoom(currentPage, pageSize, room);
    }

    @GetMapping("query/type")
    public Result<?> queryType(@RequestParam(defaultValue = "1") Integer currentPage,
                               @RequestParam(defaultValue = "-1") Integer pageSize,
                               @RequestParam(defaultValue = "") Integer type) {
        return service.queryType(currentPage, pageSize, type);
    }

    @GetMapping("query/floor")
    public Result<?> queryFloor(@RequestParam(defaultValue = "1") Integer currentPage,
                                @RequestParam(defaultValue = "-1") Integer pageSize,
                                @RequestParam(defaultValue = "") Integer floor) {
        return service.queryFloor(currentPage, pageSize, floor);
    }

    @GetMapping("query/all")
    public Result<?> queryAll(@RequestParam(defaultValue = "1") Integer currentPage,
                              @RequestParam(defaultValue = "-1") Integer pageSize,
                              @RequestParam(defaultValue = "") Integer type,
                              @RequestParam(defaultValue = "") Integer keyWord) {
        return service.queryAll(currentPage, pageSize, type, keyWord);
    }
}
