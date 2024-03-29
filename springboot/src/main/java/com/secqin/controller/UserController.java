package com.secqin.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.secqin.config.Result;
import com.secqin.entity.User;
import com.secqin.service.UserService;
import com.secqin.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.xml.crypto.Data;
import java.util.Date;

@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService service;

    @GetMapping("/list")
    public Result<?> getAll(@RequestParam(defaultValue = "1") Integer currentPage,
                            @RequestParam(defaultValue = "-1") Integer pageSize) {
        return service.getAll(currentPage, pageSize);
    }

    @PutMapping("/update")
    public Result<?> update(@RequestBody User user) {
        return service.updateByID(user);
    }

    @PostMapping("/insert")
    public Result<?> insert(@RequestBody User user) {
        return service.insert(user);
    }

    @DeleteMapping("/delete")
    public Result<?> delete(@RequestBody User user) {
        return service.deleteByID(user);
    }

    @GetMapping("/query/id")
    public Result<?> queryID(@RequestParam(defaultValue = "1") Integer currentPage,
                             @RequestParam(defaultValue = "-1") Integer pageSize,
                             @RequestParam(defaultValue = "") Integer id) {
        return service.queryID(currentPage, pageSize, id);
    }

    @GetMapping("/query/username")
    public Result<?> queryUsername(@RequestParam(defaultValue = "1") Integer currentPage,
                                   @RequestParam(defaultValue = "-1") Integer pageSize,
                                   @RequestParam(defaultValue = "") String username) {
        return service.queryUsername(currentPage,pageSize,username);
    }

    @GetMapping("/query/role")
    public Result<?> queryRole(@RequestParam(defaultValue = "1") Integer currentPage,
                               @RequestParam(defaultValue = "-1") Integer pageSize,
                               @RequestParam(defaultValue = "") Integer role) {
        return service.queryRole(currentPage, pageSize, role);
    }

    @GetMapping("/query/phone")
    public Result<?> queryPhone(@RequestParam(defaultValue = "1") Integer currentPage,
                                @RequestParam(defaultValue = "-1") Integer pageSize,
                                @RequestParam(defaultValue = "") String phone) {
        return service.queryPhone(currentPage, pageSize, phone);
    }
    @GetMapping("/query/email")
    public Result<?> queryEmail(@RequestParam(defaultValue = "1") Integer currentPage,
                                @RequestParam(defaultValue = "-1") Integer pageSize,
                                @RequestParam(defaultValue = "") String email) {
        return service.queryEmail(currentPage, pageSize, email);
    }

    @GetMapping("/query/cond")
    public Result<?> queryCond(@RequestParam(defaultValue = "1") Integer currentPage,
                               @RequestParam(defaultValue = "-1") Integer pageSize,
                               @RequestParam(defaultValue = "") Integer cond) {
        return service.queryCond(currentPage, pageSize, cond);
    }

    @GetMapping("/query/room")
    public Result<?> queryRoom(@RequestParam(defaultValue = "1") Integer currentPage,
                               @RequestParam(defaultValue = "-1") Integer pageSize,
                               @RequestParam(defaultValue = "") Integer room) {
        return service.queryRoom(currentPage, pageSize, room);
    }

    @GetMapping("/query/inTime")
    public Result<?> queryInTime(@RequestParam(defaultValue = "1") Integer currentPage,
                                 @RequestParam(defaultValue = "-1") Integer pageSize,
                                 @RequestParam(defaultValue = "") Date inTime) {
        return service.queryInTime(currentPage, pageSize, inTime);
    }

    @GetMapping("/query/outTime")
    public Result<?> queryOutTime(@RequestParam(defaultValue = "1") Integer currentPage,
                                  @RequestParam(defaultValue = "-1") Integer pageSize,
                                  @RequestParam(defaultValue = "") Date outTime) {
        return service.queryOutTime(currentPage, pageSize, outTime);
    }

    @PostMapping("/login")
    public Result<?> login(@RequestParam(defaultValue = "") String username,
                           @RequestParam(defaultValue = "") String password) {
        return service.login(username, password);
    }

    @PostMapping("/register")
    public Result<?> register(@RequestBody User user) {
        return service.register(user);
    }
}
