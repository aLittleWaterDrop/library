package com.wjl.library.control;

import com.wjl.library.bean.Book;
import com.wjl.library.services.BookService;
import com.wjl.library.services.SortService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

/**
 * @Description 这是
 * @create 2022-02-28 15:56
 */
@Controller
public class ManagerBookControl {

    @Autowired
    BookService bookService;
    @Autowired
    SortService sortService;

    @RequestMapping("bookShowLend/{id}")
    public String bookShowLend(@PathVariable("id") Integer bookId, Model model) {
        bookService.bookShowLend(bookId, model);
        return "/manager/bookShowLend";
    }

    @RequestMapping("/deleteBook/{id}")
    public String deleteBook(@PathVariable("id") Integer id,Model model) {
        return bookService.deleteBookById(id,model);
    }

    @RequestMapping("/addBook")
    public String addBook1(Model model) {
        sortService.saveSortToAttribute(model);
        return "/manager/bookAdd";
    }

    @PostMapping("/addBook")
    public String addBook2(Book book,@Param("sortId") Integer sortId) {

        if (sortId==null){

        }
        book.setGetTime(new Date());
        bookService.addBook(book,sortId);
        return "redirect:/index2.html";
    }

    @RequestMapping("/updateBook/{id}")
    public String updateBook1(@PathVariable("id") Integer id, Model model) {
        bookService.saveBookByIdToAttribute(id,model);
        sortService.saveSortToAttribute(model);
        return "/manager/bookUpdate";
    }

    @PostMapping("/updateBook")
    public String updateBook2(Book book,@Param("sortId") Integer sortId) {
        bookService.updateBook(book,sortId);
        return "redirect:/index2.html";
    }
}
