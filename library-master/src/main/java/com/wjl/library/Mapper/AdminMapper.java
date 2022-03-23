package com.wjl.library.Mapper;

import com.wjl.library.bean.Admin;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Description 这是
 * @create 2022-02-26 17:24
 */
@Mapper
public interface AdminMapper {

    public Admin getAdmin(@Param("username")String username, @Param("password")String password);

    @Update("update admin set username=#{username},password=#{password} where id=#{id}")
    public void updateAdmin(Admin admin);

    @Select("select * from admin where (id=#{id} and isRoot=1) ")
    public Admin getRootAdmin(Integer id);

    @Select("select * from admin")
    public List<Admin> getAllAdmin();

    @Insert("insert into admin (username,password,isRoot) values (#{username},#{password},#{isRoot}) ")
    public void addAdmin(Admin admin);

    @Select("select * from admin where id=#{id}")
    public Admin getAdminById(Integer id);

    @Delete("delete from admin where id=#{id}")
    public void deleteAdminById(Integer id);
}
