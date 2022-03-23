package com.wjl.library.Mapper;

import com.wjl.library.bean.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Description 这是
 * @create 2022-02-25 22:12
 */
@Mapper
public interface UserMapper {
    @Select("select * from user where username=#{username} and password=#{password}")
    public User getUser(@Param("username")String username, @Param("password")String password);

    @Update("update user set username=#{username},password=#{password} where id=#{id}")
    public void updateUser(User user);

    @Select("select * from user")
    public List<User> getAllUser();

    @Insert("insert into user(username,password,state)values(#{username},#{password},#{state})")
    public void addUser(User user);

    @Select("select * from user where id=#{id}")
    public User getUserByID(Integer id);

    @Update("update user set state=#{state} where id=#{userId}")
    public void setUserStateById(Integer userId, Integer state);

    @Delete("delete from user where id=#{id}")
    public void deleteUserById(Integer id);

}
