package com.wjl.library.control;

import com.wjl.library.Mapper.BookMapper;
import com.wjl.library.Mapper.LendMapper;
import com.wjl.library.bean.User;
import com.wjl.library.services.LendService;
import com.wjl.library.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @Description 这是
 * @create 2022-02-28 15:55
 */
@Controller
public class LendControl {

    @Autowired
    LendService lendService;
    @Autowired
    UserService userService;

    @RequestMapping("my")
    public String my(HttpSession session, Model model) {
        User user = (User) session.getAttribute("loginUser");
        if (user == null) {
            model.addAttribute("msg", "请先登录");
            return "login";
        }
        if (user.getId() == 0) {
            model.addAttribute("msg", "请先登录");
            return "login";
        }
        int id = user.getId();
        lendService.checkLend(id, model);
        lendService.saveLendBooksIdByUserIdToAttribute(id, model);
        lendService.saveLendIdsByUserIdToAttribute(id, model);
        return "my";
    }


    @RequestMapping("/borrow/{id}")
    public String borrow(@PathVariable("id") Integer bookId, HttpSession session, Model model) {
        User user = (User) session.getAttribute("loginUser");
        if (user == null) {
            model.addAttribute("msg", "请先登录");
            return "login";
        }
        boolean userExist = userService.checkUserExist(user);
        if (!userExist) {
            return "/login";
        }

        return lendService.borrowOneBook(user.getId(), bookId, model);
    }

    @RequestMapping("/sendBack/{lendid}")
    public String sendBack(@PathVariable("lendid") Integer lendid) {
        lendService.sendBackOneBook(lendid);
        return "redirect:/my";

    }
}
