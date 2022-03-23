package com.wjl.library.services;

import com.wjl.library.Mapper.BookMapper;
import com.wjl.library.Mapper.LendMapper;
import com.wjl.library.bean.Book;
import com.wjl.library.bean.Lend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @Description 这是
 * @create 2022-02-28 18:09
 */
@Service
public class LendService {

    @Autowired
    LendMapper lendMapper;
    @Autowired
    BookMapper bookMapper;

    public void saveLendBooksIdByUserIdToAttribute(Integer id, Model model) {
        List<Book> lendBooks = lendMapper.getLendBooksByUserId(id);
        model.addAttribute("lendBooks", lendBooks);
    }

    public void saveLendIdsByUserIdToAttribute(Integer id, Model model) {
        List<Lend> lendsByUserId = lendMapper.getLendsByUserId(id);
        model.addAttribute("lendsByUserId",lendsByUserId);
    }

    @Transactional
    public String borrowOneBook(Integer userId, Integer bookId, Model model) {
        Book book = bookMapper.getBookByID(bookId);
        Integer stack = book.getStack();
        if (stack > 0) {
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.MONTH,2);//获取当前时间并加2
            Date date=calendar.getTime();
            Lend lend = new Lend();
            lend.setBookId(bookId);
            lend.setUserId(userId);
            lend.setDeadline(date);
            lendMapper.addLend(lend);
            bookMapper.reduceBookOneStack(bookId);
            return "redirect:/my";
        } else {
            model.addAttribute("noBook","抱歉,本书已经无库存了!");
            return "/search";
        }
    }

    @Transactional
    public void sendBackOneBook(Integer lendid){
        Integer bookId = lendMapper.getBookIdByID(lendid);
        lendMapper.deleteLend(lendid);
        bookMapper.addBookOneStack(bookId);
    }

    public void checkLend(Integer userId,Model model){
        List<Lend> lends = lendMapper.getLendsByUserId(userId);
        if (lends.isEmpty()){
            model.addAttribute("tip","还没有借阅");
        }
        Date nowDate = new Date();
        for (Lend lend : lends) {
            Date deadline = lend.getDeadline();
            if (nowDate.after(deadline)){
                model.addAttribute("getDeadline","以下图书已有借阅逾期,请注意及时归还!");
                return;
            }
        }
    }

}
