package com.wjl.library.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wjl.library.bean.Book;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Description 这是
 * @create 2022-02-26 9:18
 */
@Mapper
public interface BookMapper extends BaseMapper<Book> {

    @Select("select * from book ")
    public List<Book> getAllBook();

    public List<Book> getBook8ByGetTime();

    public List<Book> getAllBookOrderByStack();

    public List<Book> getBookLike(String likeName);


    @Update("update book set stack=stack-1 where id=#{id}")
    public void reduceBookOneStack(Integer id);

    @Update("update book set stack=stack+1 where id=#{id}")
    public void addBookOneStack(Integer id);

    @Select("select * from book where id=#{id} ")
    public Book getBookByID(Integer id);

    @Select("select * from book where id=#{id} and stack>0")
    public Book getBookByIDExist(Integer id);

    @Delete("delete from book where id=#{id}")
    public void deleteBookByID(Integer id);

    public void addBook(Book book);

    @Update("update book set name=#{name},author=#{author},img=#{img},about=#{about},stack=#{stack} where id=#{id}")
    public void updateBook(Book book);

    @Select("select * from book where sort=#{id}")
    public List<Book> getBooksBySortID(Integer id);

    public List<Book> getAllBookSort();

    @Update("update book set sort=#{sortId} where id=#{bookId}")
    public void setBookSort(@Param("bookId")Integer bookId,@Param("sortId")Integer sortId);

}
