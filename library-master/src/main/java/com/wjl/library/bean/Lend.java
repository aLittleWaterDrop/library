package com.wjl.library.bean;

import lombok.Data;

import java.util.Date;

/**
 * @Description 这是
 * @create 2022-02-28 10:01
 */
@Data
public class Lend {
    private Integer id;
    private Integer userId;
    private Integer bookId;
    private Date deadline;//还书的截止日期
}
