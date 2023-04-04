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

    private Page<User> getPageEQ(String username) {
        return userMapper.selectPage(new Page<>(1, 1), Wrappers.<User>lambdaQuery().eq(User::getUsername, username));
    }

    private boolean containUser(String username) {
        return userMapper.selectOne(Wrappers.<User>lambdaQuery().eq(User::getUsername, username)) != null;
    }

//    private Page<User> getPagesLike(String sign, Integer currentPage, Integer pageSize, String keyWord) {
//        if (sign == "username") {
//            return userMapper.selectPage(new Page<>(currentPage, pageSize), Wrappers.<User>lambdaQuery().like(User::getUsername, keyWord));
//        } else if (sign == "password") {
//            return userMapper.selectPage(new Page<>(currentPage, pageSize), Wrappers.<User>lambdaQuery().like(User::getPassword, keyWord));
//        }  else if (sign == "role") {
//            return userMapper.selectPage(new Page<>(currentPage, pageSize), Wrappers.<User>lambdaQuery().like(User::getRole, keyWord));
//        } else if (sign == "phone") {
//            return userMapper.selectPage(new Page<>(currentPage, pageSize), Wrappers.<User>lambdaQuery().like(User::getPhone, keyWord));
//        } else if (sign == "email") {
//            return userMapper.selectPage(new Page<>(currentPage, pageSize), Wrappers.<User>lambdaQuery().like(User::getEmail, keyWord));
//        } else if (sign == "cond") {
//            return userMapper.selectPage(new Page<>(currentPage, pageSize), Wrappers.<User>lambdaQuery().like(User::getCond, keyWord));
//        } else if (sign == "room") {
//            return userMapper.selectPage(new Page<>(currentPage, pageSize), Wrappers.<User>lambdaQuery().like(User::getRoom, keyWord));
//        } else if (sign == "inTime") {
//            return userMapper.selectPage(new Page<>(currentPage, pageSize), Wrappers.<User>lambdaQuery().like(User::getInTime, keyWord));
//        } else if (sign == "outTime") {
//            return userMapper.selectPage(new Page<>(currentPage, pageSize), Wrappers.<User>lambdaQuery().like(User::getOutTime, keyWord));
//        } else {
//            return new Page<>();
//        }
//    }

    @GetMapping("/list")
    public Result<?> getAll() {
        Page<User> userPage = userMapper.selectPage(new Page<>(1, 1000), Wrappers.<User>lambdaQuery().ne(User::getId, 0));
        return Result.succes(userPage);
    }

    @GetMapping("/query/username")
    public Result<?> queryUsername(@RequestParam(defaultValue = "1") Integer currentPage,
                                   @RequestParam(defaultValue = "10") Integer pageSize,
                                   @RequestParam(defaultValue = "") String username) {
        Page<User> userPage = userMapper.selectPage(new Page<>(currentPage, pageSize), Wrappers.<User>lambdaQuery().like(User::getUsername, username));
        return Result.succes(userPage);
    }

    @GetMapping("/query/password")
    public Result<?> queryPassword(@RequestParam(defaultValue = "1") Integer currentPage,
                                   @RequestParam(defaultValue = "10") Integer pageSize,
                                   @RequestParam(defaultValue = "") String password) {
        Page<User> userPage = userMapper.selectPage(new Page<>(currentPage, pageSize), Wrappers.<User>lambdaQuery().like(User::getUsername, password));
        return Result.succes(userPage);
    }
    @GetMapping("/query/role")
    public Result<?> queryRole(@RequestParam(defaultValue = "1") Integer currentPage,
                               @RequestParam(defaultValue = "10") Integer pageSize,
                               @RequestParam(defaultValue = "") String role) {
        Page<User> userPage = userMapper.selectPage(new Page<>(currentPage, pageSize), Wrappers.<User>lambdaQuery().like(User::getUsername, role));
        return Result.succes(userPage);
    }

    @GetMapping("/query/phone")
    public Result<?> queryPhone(@RequestParam(defaultValue = "1") Integer currentPage,
                                @RequestParam(defaultValue = "10") Integer pageSize,
                                @RequestParam(defaultValue = "") String phone) {
        Page<User> userPage = userMapper.selectPage(new Page<>(currentPage, pageSize), Wrappers.<User>lambdaQuery().like(User::getUsername, phone));
        return Result.succes(userPage);
    }
    @GetMapping("/query/email")
    public Result<?> queryEmail(@RequestParam(defaultValue = "1") Integer currentPage,
                                @RequestParam(defaultValue = "10") Integer pageSize,
                                @RequestParam(defaultValue = "") String email) {
        Page<User> userPage = userMapper.selectPage(new Page<>(currentPage, pageSize), Wrappers.<User>lambdaQuery().like(User::getUsername, email));
        return Result.succes(userPage);
    }

    @GetMapping("/query/cond")
    public Result<?> queryCond(@RequestParam(defaultValue = "1") Integer currentPage,
                               @RequestParam(defaultValue = "10") Integer pageSize,
                               @RequestParam(defaultValue = "") String cond) {
        Page<User> userPage = userMapper.selectPage(new Page<>(currentPage, pageSize), Wrappers.<User>lambdaQuery().like(User::getUsername, cond));
        return Result.succes(userPage);
    }

    @GetMapping("/query/room")
    public Result<?> queryRoom(@RequestParam(defaultValue = "1") Integer currentPage,
                               @RequestParam(defaultValue = "10") Integer pageSize,
                               @RequestParam(defaultValue = "") String room) {
        Page<User> userPage = userMapper.selectPage(new Page<>(currentPage, pageSize), Wrappers.<User>lambdaQuery().like(User::getUsername, room));
        return Result.succes(userPage);
    }

    @GetMapping("/query/inTime")
    public Result<?> queryInTime(@RequestParam(defaultValue = "1") Integer currentPage,
                                 @RequestParam(defaultValue = "10") Integer pageSize,
                                 @RequestParam(defaultValue = "") String inTime) {
        Page<User> userPage = userMapper.selectPage(new Page<>(currentPage, pageSize), Wrappers.<User>lambdaQuery().like(User::getUsername, inTime));
        return Result.succes(userPage);
    }

    @GetMapping("/query/outTime")
    public Result<?> queryOutTime(@RequestParam(defaultValue = "1") Integer currentPage,
                                  @RequestParam(defaultValue = "10") Integer pageSize,
                                  @RequestParam(defaultValue = "") String outTime) {
        Page<User> userPage = userMapper.selectPage(new Page<>(currentPage, pageSize), Wrappers.<User>lambdaQuery().like(User::getUsername, outTime));
        return Result.succes(userPage);
    }

    @PostMapping("/insert")
    public Result<?> save(@RequestBody User user) {
//        User tempUser = userMapper.selectOne(Wrappers.<User>lambdaQuery().eq(User::getUsername, user.getUsername()));
        if (containUser(user.getUsername())) {
            return Result.error("-1", "用户名已经存在");
        } else {
            userMapper.insert(user);
            return Result.succes(getPageEQ(user.getUsername()));
        }
    }

    @PutMapping("/update")
    public Result<?> update(@RequestBody User user) {
        userMapper.updateById(user);
        return Result.succes(getPageEQ(user.getUsername()));
    }

    @DeleteMapping("/delete")
    public Result<?> delete(@RequestBody User user) {
        userMapper.deleteById(user.getId());
        return Result.succes();
    }
}
