package com.secqin.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("room")
@Data
public class Room {
    @TableId(type = IdType.AUTO)
    private Integer id;
    /**
     * 房间号
     */
    private Integer room;
    /**
     * 房间类型
     */
    private String type;
    /**
     * 房间楼层
     */
    private Integer floor;
    /**
     * 是否空闲
     */
    private Integer available;
    /**
     * 展示图片1
     */
    private String picture1;
    /**
     * 展示图片2
     */
    private String picture2;
    /**
     * 展示图片3
     */
    private String picture3;
    /**
     * 展示图片4
     */
    private String picture4;
}
