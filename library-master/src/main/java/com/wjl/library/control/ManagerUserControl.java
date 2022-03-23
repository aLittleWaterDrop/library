package com.wjl.library.control;

import com.wjl.library.bean.Sort;
import com.wjl.library.bean.User;
import com.wjl.library.services.BookService;
import com.wjl.library.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Description 这是
 * @create 2022-03-03 11:16
 */
@Controller
public class ManagerUserControl {

    @Autowired
    UserService userService;

    @RequestMapping("/userManager")
    public String userManager(Model model) {
        userService.saveUsersToAttribute(model);
        return "/manager/userManager";
    }

    @RequestMapping("addUser")
    public String addUser() {
        return "/manager/userAdd";
    }

    @PostMapping("addUser")
    public String addUser(User user) {
        userService.addUser(user);
        return "redirect:/userManager";
    }

    @RequestMapping("updateUser/{userId}")
    public String updateUser(@PathVariable("userId") Integer userId, Model model) {
        userService.saveUserByIdToAttribute(userId, model);
        return "/manager/userUpdate";
    }

    @PostMapping("updateUser")
    public String updateUser(User user) {
        userService.updateUser(user);
        return "redirect:/userManager";
    }

    @RequestMapping("lockUser/{id}")
    public String lockUser(@PathVariable("id") Integer userId) {
        userService.lockUser(userId);
        return "redirect:/userManager";

    }

    @RequestMapping("showLend/{id}")
    public String showLend(@PathVariable("id") Integer userId, Model model) {
        userService.showLend(userId, model);
        return "/manager/userShowLend";
    }


    @RequestMapping("deleteUser/{id}")
    public String deleteUser(@PathVariable("id") Integer userId, Model model) {
        return userService.deleteUser(userId, model);

    }


}
