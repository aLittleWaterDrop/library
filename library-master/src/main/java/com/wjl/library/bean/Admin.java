package com.wjl.library.bean;

import lombok.Data;

import java.util.List;

/**
 * @Description 这是
 * @create 2022-02-26 17:23
 */
@Data
public class Admin {

    private int id;
    private String username;
    private String password;
    private Integer isRoot;

}
