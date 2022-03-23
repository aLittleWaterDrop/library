package com.wjl.library.Mapper;

import com.wjl.library.bean.Book;
import com.wjl.library.bean.Sort;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Description 这是
 * @create 2022-03-01 9:59
 */
@Mapper
public interface SortMapper {
    @Select("select * from sort")
    public List<Sort> getSorts();

//    @Select("select book_id from book_sort where sort_id=#{id}")
//    public List<Integer> getBookIdsBySortId(Integer id);

    @Insert("insert into sort (sort_name) values (#{sortName}) ")
    public void addSort(String sortName);

    @Select("select * from sort where id=#{id}")
    public Sort getSortById(Integer id);

    @Update("update sort set sort_name =#{sortName} where id=#{id}")
    public void updateSort(Sort sort);

    @Delete("delete from sort where id=#{id}")
    public void deleteSortById(Integer id);

    @Select("select * from sort limit 1")
    public Sort getFirstSort();
}
