package com.secqin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.secqin.entity.Order;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper extends BaseMapper<Order> {
}
