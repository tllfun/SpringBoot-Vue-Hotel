package com.secqin.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.secqin.config.Result;
import com.secqin.entity.User;
import com.secqin.mapper.UserMapper;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    UserMapper userMapper;
    @GetMapping
    public Result<?> findPage(@RequestParam(defaultValue = "1") Integer currentPage,
                              @RequestParam(defaultValue = "10") Integer pageSize,
                              @RequestParam(defaultValue = "test") String keyWord) {
        Page<User> userPage = userMapper.selectPage(new Page<>(currentPage, pageSize), Wrappers.<User>lambdaQuery().like(User::getUsername, keyWord));
        return Result.succes(userPage);
    }

    @PostMapping
    public Result<?> save(@RequestBody User user) {
        userMapper.insert(user);
        Page<User> userPage = userMapper.selectPage(new Page<>(1, 1), Wrappers.<User>lambdaQuery().eq(User::getUsername, user.getUsername()));
        return Result.succes(userPage);
    }

    @PutMapping
    public Result<?> update(@RequestBody User user) {
        userMapper.updateById(user);
        return Result.succes();
    }
}
