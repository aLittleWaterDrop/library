package com.wjl.library.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @Description 这是
 * @create 2022-02-26 9:19
 */
@Data
@TableName("book")
public class Book {
    private Integer id;
    private String name;
    private String img;
    private String author;
    private String about;
    private Integer stack;
    private Date getTime;
    @TableField(exist = false)//表中并无此字段
    private Sort sort;
}
