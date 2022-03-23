package com.wjl.library.services;

import com.wjl.library.Mapper.LendMapper;
import com.wjl.library.Mapper.UserMapper;
import com.wjl.library.bean.Book;
import com.wjl.library.bean.Lend;
import com.wjl.library.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

/**
 * @Description 这是
 * @create 2022-03-03 11:20
 */
@Service
public class UserService {

    @Autowired
    UserMapper userMapper;
    @Autowired
    LendMapper lendMapper;

    public void saveUsersToAttribute(Model model) {
        List<User> users = userMapper.getAllUser();
        model.addAttribute("users", users);
    }

    public void addUser(User user) {
        user.setState(1);
        userMapper.addUser(user);
    }

    public void saveUserByIdToAttribute(Integer userId, Model model) {
        User userById = userMapper.getUserByID(userId);
        model.addAttribute("userById", userById);
    }

    public void updateUser(User user) {
        userMapper.updateUser(user);
    }

    public void lockUser(Integer userId) {
        User userByID = userMapper.getUserByID(userId);
        System.out.println(userByID);
        Integer state = userByID.getState();
        if (1 == state) {
            userMapper.setUserStateById(userId, 0);
        } else if (0 == state) {
            userMapper.setUserStateById(userId, 1);
        }
    }

    public void showLend(Integer userId, Model model) {
        String username = userMapper.getUserByID(userId).getUsername();
        List<Book> lendBooks = lendMapper.getLendBooksByUserId(userId);
        List<Lend> lends = lendMapper.getLendsByUserId(userId);
        model.addAttribute("lendBooks", lendBooks);
        model.addAttribute("lends", lends);
        model.addAttribute("userInfo", "【" + username + "】的借阅信息：");
        if (lendBooks.isEmpty()) {
            model.addAttribute("userInfo2", "该用户未借阅图书");
        }
    }

    public String deleteUser(Integer userId, Model model) {
        List<Lend> lends = lendMapper.getLendsByUserId(userId);

        if (lends.isEmpty()) {
            userMapper.deleteUserById(userId);
            return "redirect:/userManager";
        } else {
            List<Book> lendBooks = lendMapper.getLendBooksByUserId(userId);
            String username = userMapper.getUserByID(userId).getUsername();
            model.addAttribute("lendBooks", lendBooks);
            model.addAttribute("lends", lends);
            model.addAttribute("userInfo", "【" + username + "】还存在以下借阅,不能将其删除：");
            return "/manager/userShowLend";
        }
    }

    public User getUserById(Integer id) {
        return userMapper.getUserByID(id);

    }

    public boolean checkUserExist(User loginUser) {
        if (loginUser == null) return false;
        if (loginUser.getUsername() == "游客") return false;
        User user = userMapper.getUserByID(loginUser.getId());
        return user != null;
    }
}
