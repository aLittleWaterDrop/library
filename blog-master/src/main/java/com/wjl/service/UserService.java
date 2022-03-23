package com.wjl.service;

import com.wjl.po.User;


public interface UserService {

    User checkUser(String username, String password);
}
