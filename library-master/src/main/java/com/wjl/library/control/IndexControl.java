package com.wjl.library.control;

import com.wjl.library.bean.User;
import com.wjl.library.services.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * @Description 这是
 * @create 2022-02-25 21:40
 */
@Slf4j
@Controller
public class IndexControl {


    @Autowired
    BookService bookService;

//    @RequestMapping({"/", "/index"})
//    public String index(HttpSession session, Model model) {
//        User user = (User) session.getAttribute("loginUser");
//        if (user == null) {
//            User user1 = new User();
//            user1.setUsername("游客");
//            session.setAttribute("loginUser", user1);
//        }
//        bookService.save8BookToAttribute(model);
//        return "index";
//    }

    @GetMapping({"/", "/index"})
    public String indexPage(Model model) {
        bookService.save8BookToAttribute(model);
        return "index";
    }


    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String login(String username, String password, HttpSession session, Model model) {
        //账户密码正确则登录
        User user = bookService.checkUser(username, password);
        if (user != null) {
            Integer isAvailable = user.getState();
            if (isAvailable == 1) {
                session.setAttribute("loginUser", user);
                return "redirect:/index";
            } else {
                model.addAttribute("msg", "该用户已被锁定,请联系管理员");
                return "login";
            }
            //密码错误
        } else {
            model.addAttribute("msg", "账户或密码错误,请重新输入");
            return "login";
        }

    }

    @RequestMapping("updateUserPassword")
    public String updatePassword() {
        return "updateUserPassword";
    }


    @PostMapping("updateUserPassword")
    public String updatePassword2(HttpSession session, Model model,
                                  @RequestParam("originPswd") String originPswd,
                                  @RequestParam("newPswd") String newPswd

    ) {

        User loginUser = (User) session.getAttribute("loginUser");
        String username = loginUser.getUsername();
        User user = bookService.checkUser(username, originPswd);
        if (user == null) {
            model.addAttribute("msg", "原密码错误,请重新输入");
            return "updateUserPassword";
        } else {
            bookService.updateUserPassword(user, newPswd);
            session.removeAttribute("loginUser");
            model.addAttribute("msg", "修改成功,请重新登陆");
            return "/login";
        }
    }

}
