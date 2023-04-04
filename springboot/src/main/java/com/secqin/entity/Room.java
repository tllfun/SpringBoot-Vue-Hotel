package com.secqin.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("Room")
@Data
public class Room {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer room;
    private Integer floor;
    private Integer available;
    private String picture1;
    private String picture2;
    private String picture3;
    private String picture4;
}
