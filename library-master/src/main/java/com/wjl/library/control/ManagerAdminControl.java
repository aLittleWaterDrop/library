package com.wjl.library.control;

import com.wjl.library.bean.Admin;
import com.wjl.library.bean.User;
import com.wjl.library.services.AdminService;
import com.wjl.library.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @Description 这是
 * @create 2022-03-03 20:06
 */
@Controller
public class ManagerAdminControl {

    @Autowired
    AdminService adminService;

    @RequestMapping("/adminManager")
    public String adminManager(Model model, HttpSession session) {
        Admin admin= (Admin) session.getAttribute("loginAdmin");
        Admin rootAdmin = adminService.checkRootAdmin(admin.getId());
        if (rootAdmin!=null){
            adminService.saveAdminToAttribute(model);
            return "/manager/adminManager";
        }else {
            model.addAttribute("msg2", "请使用超级管理员账户登录");
            return "/manager/login2";
        }

    }

    @RequestMapping("addAdmin")
    public String addAdmin() {
        return "/manager/adminAdd";
    }

    @PostMapping("addAdmin")
    public String addAdmin(Admin admin) {
        adminService.addAdmin(admin);
        return "redirect:/adminManager";
    }

    @RequestMapping("updateAdmin/{id}")
    public String updateAdmin(@PathVariable("id") Integer id, Model model) {
        adminService.saveAdminByIdToAttribute(id, model);
        return "/manager/adminUpdate";
    }

    @PostMapping("updateAdmin")
    public String updateAdmin(Admin admin) {
        adminService.updateAdmin(admin);
        return "redirect:/adminManager";
    }

    @RequestMapping("deleteAdmin/{id}")
    public String deleteUser(@PathVariable("id") Integer adminId, Model model) {
        adminService.deleteAdmin(adminId);
        return "redirect:/adminManager";

    }
}
