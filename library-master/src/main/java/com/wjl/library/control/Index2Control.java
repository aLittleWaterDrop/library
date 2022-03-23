package com.wjl.library.control;

import com.wjl.library.Mapper.AdminMapper;
import com.wjl.library.Mapper.BookMapper;
import com.wjl.library.bean.Admin;
import com.wjl.library.services.AdminService;
import com.wjl.library.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * @Description 这是
 * @create 2022-02-28 16:04
 */
@Controller
public class Index2Control {

    @Autowired
    AdminMapper adminMapper;
    @Autowired
    BookMapper bookMapper;
    @Autowired
    AdminService adminService;
    @Autowired
    BookService bookService;

    @RequestMapping("/manager")
    public String manager(Model model) {
        return "/manager/login2";
    }

    @RequestMapping("/login2")
    public String login2(String username, String password, HttpSession session, Model model) {
        Admin admin = adminService.checkAdmin(username, password);
        if (username == null && password == null) {
            model.addAttribute("msg2", "请使用管理员账户登录");
            return "/manager/login2";
        } else if (admin == null) {
            model.addAttribute("msg2", "账号或密码错误,请重新输入");
            return "/manager/login2";
        } else {
            session.setAttribute("loginAdmin", admin);
            return "redirect:/index2.html";
        }

    }

    @GetMapping("index2")
    public String index2(Model model) {
        bookService.saveAllBookToAttribute(model);
        return "manager/index2";
    }

    @GetMapping("/index2.html")
    public String indexPage(Model model) {
        bookService.saveAllBookToAttribute(model);
        return "manager/index2";
    }

    @RequestMapping("updateAdminPassword")
    public String updateAdminPassword() {
        return "/manager/updateAdminPassword";
    }

    @PostMapping("updateAdminPassword")
    public String updateAdminPassword(HttpSession session, Model model,
                                      @RequestParam("originPswd") String originPswd,
                                      @RequestParam("newPswd") String newPswd

    ) {

        Admin loginAdmin = (Admin) session.getAttribute("loginAdmin");
        String username = loginAdmin.getUsername();
        Admin admin = adminService.checkAdmin(username, originPswd);
        if (admin == null) {
            model.addAttribute("msg", "原密码错误,请重新输入");
            return "/manager/updateAdminPassword";
        } else {
            adminService.updateAdminPassword(admin, newPswd);
            session.removeAttribute("loginAdmin");
            model.addAttribute("msg2", "修改成功,请重新登陆");
            return "/manager/login2";
        }
    }

}
