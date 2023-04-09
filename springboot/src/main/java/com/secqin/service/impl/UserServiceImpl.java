package com.secqin.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.secqin.config.Result;
import com.secqin.entity.User;
import com.secqin.mapper.UserMapper;
import com.secqin.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Resource
    private UserMapper mapper;

    private User getNewUserByID(User user) {
        return mapper.selectById(user.getId());
    }
    private User getNewUserByName(String username) {
        return mapper.selectOne(Wrappers.<User>lambdaQuery().eq(User::getUsername, username));
    }

    @Override
    public Result getAll() {
        Page<User> userPage = mapper.selectPage(new Page<>(1, -1), Wrappers.<User>lambdaQuery().ne(User::getId, 0));
        return Result.succes(userPage);
    }

    @Override
    public Result updateByID(User user) {
        User userSelectByID = mapper.selectById(user.getId());
        if (userSelectByID == null) {
            return Result.error("-1", "用户ID不存在");
        } else {
            User userSelectByUsername = mapper.selectOne(Wrappers.<User>lambdaQuery().eq(User::getUsername, user.getUsername()));
            if (userSelectByUsername == null) {
                mapper.updateById(user);
                return Result.succes(getNewUserByID(user));
            } else {
                if (userSelectByID.getId().equals(userSelectByUsername.getId())) {
                    mapper.updateById(user);
                    return Result.succes(getNewUserByID(user));
                } else {
                    return Result.error("-1", "更新失败 用户名已存在");
                }
            }
        }
    }

    @Override
    public Result insert(User user) {
        User user1 = mapper.selectOne(Wrappers.<User>lambdaQuery().eq(User::getUsername, user.getUsername()));
        if (user1 != null) {
            return Result.error("-1", "用户昵称已经存在");
        } else {
            mapper.insert(user);
            return Result.succes(getNewUserByName(user.getUsername()));
        }
    }

    @Override
    public Result deleteByID(Integer id) {
        User user1 = mapper.selectById(id);
        if (user1 == null) {
            return Result.error("-1", "用户ID不存在");
        } else {
            mapper.deleteById(id);
            return Result.succes("删除成功");
        }
    }

    @Override
    public Result queryID(Integer id) {
        Page<User> page = mapper.selectPage(new Page<>(1, -1), Wrappers.<User>lambdaQuery().eq(User::getId, id));
        return Result.succes(page);
    }

    @Override
    public Result queryUsername(Integer currentPage, Integer pageSize, String keyWord) {
        Page<User> page = mapper.selectPage(new Page<>(currentPage, pageSize), Wrappers.<User>lambdaQuery().eq(User::getUsername, keyWord));
        return Result.succes(page);
    }

    @Override
    public Result queryPassword(Integer currentPage, Integer pageSize, String keyWord) {
        Page<User> page = mapper.selectPage(new Page<>(currentPage, pageSize), Wrappers.<User>lambdaQuery().eq(User::getPassword, keyWord));
        return Result.succes(page);
    }

    @Override
    public Result queryRole(Integer currentPage, Integer pageSize, Integer keyWord) {
        Page<User> page = mapper.selectPage(new Page<>(currentPage, pageSize), Wrappers.<User>lambdaQuery().eq(User::getRole, keyWord));
        return Result.succes(page);
    }

    @Override
    public Result queryPhone(Integer currentPage, Integer pageSize, String keyWord) {
        Page<User> page = mapper.selectPage(new Page<>(currentPage, pageSize), Wrappers.<User>lambdaQuery().eq(User::getPhone, keyWord));
        return Result.succes(page);
    }

    @Override
    public Result queryEmail(Integer currentPage, Integer pageSize, String keyWord) {
        Page<User> page = mapper.selectPage(new Page<>(currentPage, pageSize), Wrappers.<User>lambdaQuery().eq(User::getEmail, keyWord));
        return Result.succes(page);
    }

    @Override
    public Result queryCond(Integer currentPage, Integer pageSize, Integer keyWord) {
        Page<User> page = mapper.selectPage(new Page<>(currentPage, pageSize), Wrappers.<User>lambdaQuery().eq(User::getCond, keyWord));
        return Result.succes(page);
    }

    @Override
    public Result queryRoom(Integer currentPage, Integer pageSize, Integer keyWord) {
        Page<User> page = mapper.selectPage(new Page<>(currentPage, pageSize), Wrappers.<User>lambdaQuery().eq(User::getRoom, keyWord));
        return Result.succes(page);
    }

    @Override
    public Result queryInTime(Integer currentPage, Integer pageSize, Date keyWord) {
        Page<User> page = mapper.selectPage(new Page<>(currentPage, pageSize), Wrappers.<User>lambdaQuery().eq(User::getInTime, keyWord));
        return Result.succes(page);
    }

    @Override
    public Result queryOutTime(Integer currentPage, Integer pageSize, Date keyWord) {
        Page<User> page = mapper.selectPage(new Page<>(currentPage, pageSize), Wrappers.<User>lambdaQuery().eq(User::getOutTime, keyWord));
        return Result.succes(page);
    }
}
