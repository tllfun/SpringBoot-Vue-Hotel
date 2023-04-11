package com.secqin.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

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
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date inTime;


    /**
     * 退房时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date outTime;

    /**
     * 修改订单的时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date updateTime;
    /**
     * 备注
     */
    private String comments;
}
