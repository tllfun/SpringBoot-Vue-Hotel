package com.secqin.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

@TableName("orders")
@Data
public class Orders {
    @TableId(type = IdType.AUTO)
    private Integer id;
    /**
     * 入住人ID
     */
    private Integer userId;
    /**
     * 经手人（管理员）ID
     */
    private Integer managerId;
    /**
     * 房间号
     */
    private Integer room;

    /**
     * 入住时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime inTime;

    /**
     * 退房时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime outTime;

    /**
     * 修改订单的时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;
    /**
     * 备注
     */
    private String comments;
}
