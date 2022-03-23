package com.wjl.library.services;

import com.wjl.library.Mapper.BookMapper;
import com.wjl.library.Mapper.SortMapper;
import com.wjl.library.bean.Book;
import com.wjl.library.bean.Sort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

/**
 * @Description 这是
 * @create 2022-03-02 9:36
 */
@Service
public class SortService {

    @Autowired
    SortMapper sortMapper;
    @Autowired
    BookMapper bookMapper;

    public void saveSortToAttribute(Model model) {
        List<Sort> sorts = sortMapper.getSorts();
        model.addAttribute("sorts", sorts);
    }

    public void addSort(String sortName) {
        sortMapper.addSort(sortName);
    }

    public void saveSortByIdToAttribute(Integer sortId, Model model) {
        Sort sortById = sortMapper.getSortById(sortId);
        model.addAttribute("sortById", sortById);
    }

    public void updateSortName(Sort sort) {
        sortMapper.updateSort(sort);
    }

    public String deleteSort(Integer sortId, Model model) {
        List<Book> booksBySort = bookMapper.getBooksBySortID(sortId);
        if (booksBySort.isEmpty()) {
            sortMapper.deleteSortById(sortId);
            return "redirect:/sortManager";
        } else {
            String sortName = sortMapper.getSortById(sortId).getSortName();
            model.addAttribute("tip", "【" + sortName + "】分类下还有以下图书,还不能删除!");
            model.addAttribute("booksBySort", booksBySort);
            return "/manager/sortShowBook";
        }
    }

    public void showSort(Integer sortId, Model model) {
        List<Book> booksBySort = bookMapper.getBooksBySortID(sortId);
        if (booksBySort.isEmpty()) {
            model.addAttribute("tip", "该分类下无图书");
        } else {
            model.addAttribute("booksBySort", booksBySort);
        }
    }

    public Sort getSortById(Integer sortId) {
       return sortMapper.getSortById(sortId);
    }
}
