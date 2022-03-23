package com.wjl.library.control;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wjl.library.bean.Book;
import com.wjl.library.services.BookService;
import com.wjl.library.services.SortService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * @Description 这是
 * @create 2022-02-28 15:55
 */
@Slf4j
@Controller
public class BookControl {
    @Autowired
    SortService sortService;
    @Autowired
    BookService bookService;

    @RequestMapping("/hot")
    public String hot(Model model) {
        bookService.saveBooksOrderByStackToAttribute(model);
        return "hot";
    }

    @PostMapping("/search")
    public String search(@RequestParam("keyWord") String keyWord, Model model) {
        bookService.saveBooksLikeToAttribute(keyWord, model);
        return "search";
    }

    @RequestMapping("/sort")
    public String sort() {
        return "redirect:/sortBook/1";
    }

    @RequestMapping("/sortBook/{sortId}")
    public String sortBook(@PathVariable("sortId") Integer sortId, Model model, @RequestParam(value = "pn", defaultValue = "1") Integer pn) {
        Page<Book> bookPage = new Page<>(pn, 4);//从pn页开始,每页四条
        QueryWrapper<Book> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("sort", sortId);//设置查询条件:when sort=#{sortId}
        Page<Book> page = bookService.page(bookPage, queryWrapper);//得到
        String sortName = sortService.getSortById(sortId).getSortName();
        if (page.getTotal() == 0) {
            model.addAttribute("tip", "【" + sortName + "】下没有图书");
        }
        model.addAttribute("page", page);
        sortService.saveSortToAttribute(model);
        return "sort";
    }

}
