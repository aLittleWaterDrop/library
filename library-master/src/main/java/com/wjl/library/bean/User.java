package com.wjl.library.bean;

import lombok.Data;

import java.util.List;

/**
 * @Description 这是
 * @create 2022-02-25 22:10
 */
@Data
public class User {
    private int id;
    private String username;
    private String password;
    private Integer state;
}
