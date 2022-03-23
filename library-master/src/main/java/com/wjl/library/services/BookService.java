package com.wjl.library.services;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wjl.library.Mapper.BookMapper;
import com.wjl.library.Mapper.LendMapper;
import com.wjl.library.Mapper.SortMapper;
import com.wjl.library.Mapper.UserMapper;
import com.wjl.library.bean.Book;
import com.wjl.library.bean.Lend;
import com.wjl.library.bean.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

/**
 * @Description 这是
 * @create 2022-02-28 16:23
 */
@Service
@Slf4j
public class BookService extends ServiceImpl<BookMapper,Book> {

    @Autowired
    BookMapper bookMapper;
    @Autowired
    UserMapper userMapper;
    @Autowired
    LendMapper lendMapper;
    @Autowired
    SortMapper sortMapper;

    public void save8BookToAttribute(Model model) {
        List<Book> books = bookMapper.getBook8ByGetTime();
        model.addAttribute("booksLimit8", books);
    }

    public void saveBooksOrderByStackToAttribute(Model model) {
        List<Book> books = bookMapper.getAllBookOrderByStack();
        model.addAttribute("booksOrderByStack", books);
    }

    public void saveBooksLikeToAttribute(String keyWord, Model model) {
        List<Book> bookLike = bookMapper.getBookLike(keyWord);
        model.addAttribute("bookLike", bookLike);
    }

    public User checkUser(String username, String password) {
        User user = userMapper.getUser(username, password);
        return user;
    }

    public void updateUserPassword(User user, String newPswd) {
        user.setPassword(newPswd);
        userMapper.updateUser(user);
    }

    public void saveAllBookToAttribute(Model model) {
        List<Book> books = bookMapper.getAllBookSort();
        model.addAttribute("bookMange", books);
    }

    public String deleteBookById(Integer id, Model model) {
        List<Lend> lends = lendMapper.getLendsByBookId(id);
        if (lends.isEmpty()) {
            bookMapper.deleteBookByID(id);
            return "redirect:/index2.html";
        } else {
            String bookName = bookMapper.getBookByID(id).getName();
            List<User> users = lendMapper.getLendUsersByBookId(id);
            model.addAttribute("users", users);
            model.addAttribute("tip", "《" + bookName + "》在被以下用户借阅,还不能删除!");
            return "/manager/bookShowLend";
        }

    }


    public void addBook(Book book, Integer sortId) {
        if (sortId == null) {
            sortId = sortMapper.getFirstSort().getId();
        }
        bookMapper.addBook(book);
        bookMapper.setBookSort(book.getId(), sortId);
    }

    public void updateBook(Book book, Integer sortId) {
        bookMapper.updateBook(book);
        if (sortId != null) {
            bookMapper.setBookSort(book.getId(), sortId);
        }
    }

    public void saveBookByIdToAttribute(Integer id, Model model) {
        Book bookByID = bookMapper.getBookByID(id);
        model.addAttribute("bookByID", bookByID);
    }

    public void saveBooksBySortIDToAttribute(Integer id, Model model) {
        List<Book> books = bookMapper.getBooksBySortID(id);
        model.addAttribute("booksBySort", books);
    }

    public void bookShowLend(Integer bookId, Model model) {
        List<User> users = lendMapper.getLendUsersByBookId(bookId);
        String bookName = bookMapper.getBookByID(bookId).getName();
        if (users.isEmpty()) {
            model.addAttribute("tip", "《" + bookName + "》" + "未被借阅");
        } else {
            model.addAttribute("tip", "《" + bookName + "》" + "被以下用户借阅：");
            model.addAttribute("users", users);
        }
    }



}
