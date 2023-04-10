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
    public Result getAll(Integer currentPage, Integer pageSize) {
        Page<User> userPage = mapper.selectPage(new Page<>(currentPage, pageSize), Wrappers.<User>lambdaQuery().ne(User::getId, 0));
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

    /**
     * 用于管理员添加用户信息
     * @param user
     * @return
     */
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
    public Result queryID(Integer currentPage, Integer pageSize, Integer id) {
        Page<User> page = mapper.selectPage(new Page<>(currentPage, pageSize), Wrappers.<User>lambdaQuery().like(User::getId, id));
        return Result.succes(page);
    }

    @Override
    public Result deleteByID(User user) {
        User user1 = mapper.selectById(user.getId());
        if (user1 == null) {
            return Result.error("-1", "用户ID不存在");
        } else {
            mapper.deleteById(user.getId());
            return Result.succes("用户删除成功");
        }
    }

    @Override
    public Result queryUsername(Integer currentPage, Integer pageSize, String keyWord) {
        Page<User> page = mapper.selectPage(new Page<>(currentPage, pageSize), Wrappers.<User>lambdaQuery().like(User::getUsername, keyWord));
        return Result.succes(page);
    }

    @Override
    public Result queryRole(Integer currentPage, Integer pageSize, Integer keyWord) {
        Page<User> page = mapper.selectPage(new Page<>(currentPage, pageSize), Wrappers.<User>lambdaQuery().eq(User::getRole, keyWord));
        return Result.succes(page);
    }

    @Override
    public Result queryPhone(Integer currentPage, Integer pageSize, String keyWord) {
        Page<User> page = mapper.selectPage(new Page<>(currentPage, pageSize), Wrappers.<User>lambdaQuery().like(User::getPhone, keyWord));
        return Result.succes(page);
    }

    @Override
    public Result queryEmail(Integer currentPage, Integer pageSize, String keyWord) {
        Page<User> page = mapper.selectPage(new Page<>(currentPage, pageSize), Wrappers.<User>lambdaQuery().like(User::getEmail, keyWord));
        return Result.succes(page);
    }

    @Override
    public Result queryCond(Integer currentPage, Integer pageSize, Integer keyWord) {
        Page<User> page = mapper.selectPage(new Page<>(currentPage, pageSize), Wrappers.<User>lambdaQuery().eq(User::getCond, keyWord));
        return Result.succes(page);
    }

    @Override
    public Result queryRoom(Integer currentPage, Integer pageSize, Integer keyWord) {
        Page<User> page = mapper.selectPage(new Page<>(currentPage, pageSize), Wrappers.<User>lambdaQuery().like(User::getRoom, keyWord));
        return Result.succes(page);
    }

    @Override
    public Result queryInTime(Integer currentPage, Integer pageSize, Date keyWord) {
        Page<User> page = mapper.selectPage(new Page<>(currentPage, pageSize), Wrappers.<User>lambdaQuery().like(User::getInTime, keyWord));
        return Result.succes(page);
    }

    @Override
    public Result queryOutTime(Integer currentPage, Integer pageSize, Date keyWord) {
        Page<User> page = mapper.selectPage(new Page<>(currentPage, pageSize), Wrappers.<User>lambdaQuery().like(User::getOutTime, keyWord));
        return Result.succes(page);
    }

    @Override
    public Result login(String username, String password) {
        User user = mapper.selectOne(Wrappers.<User>lambdaQuery().eq(User::getUsername, username));
        if (user == null) {
            return Result.error("-1", "用户名或密码错误");
        } else {
            if (user.getPassword().equals(password)) {
                return Result.succes("登录成功", getNewUserByID(user));
            } else {
                return Result.error("-1", "用户名或密码错误");
            }
        }
    }


    /**
     * 用于用户注册
     * @param user
     * @return
     */
    @Override
    public Result register(User user) {
        User user1 = mapper.selectOne(Wrappers.<User>lambdaQuery().eq(User::getUsername, user.getUsername()));
        if (user1 != null) {
            return Result.error("-1", "注册失败 用户名已存在");
        } else {
            mapper.insert(user);
            return Result.succes("注册成功");
        }
    }
}
