package com.wjl.library.Mapper;

import com.wjl.library.bean.Book;
import com.wjl.library.bean.Lend;
import com.wjl.library.bean.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Description 这是
 * @create 2022-02-28 9:09
 */
@Mapper
public interface LendMapper {
    public List<Book> getLendBooksByUserId(Integer id);

    public void addLend(Lend lend);

    @Select("select id from lend WHERE user_id=#{userId}")
    public List<Integer> getLendsIdByUserId(Integer userId);

    @Delete("delete from lend where id=#{id}")
    public void deleteLend(Integer id);

    @Select("select book_id from lend where id=#{id}" )
    public Integer getBookIdByID(Integer id);

    @Select("SELECT * FROM lend WHERE book_id=#{id}")
    public List<Lend> getLendsByBookId(Integer id);

    @Select("SELECT * FROM lend WHERE user_id=#{id}")
    public List<Lend> getLendsByUserId(Integer id);

    public List<User> getLendUsersByBookId(Integer id);
}
