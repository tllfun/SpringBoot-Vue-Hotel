package com.secqin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.secqin.entity.Room;
import com.secqin.mapper.RoomMapper;
import com.secqin.service.RoomService;
import org.springframework.stereotype.Service;

@Service
public class RoomServiceImpl extends ServiceImpl<RoomMapper, Room> implements RoomService {
}