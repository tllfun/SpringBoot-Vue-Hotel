package com.secqin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.secqin.entity.User;
import com.secqin.mapper.UserMapper;
import com.secqin.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
