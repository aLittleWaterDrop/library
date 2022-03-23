package com.wjl.library.intercept;

import com.wjl.library.bean.Admin;
import com.wjl.library.bean.User;
import com.wjl.library.services.AdminService;
import com.wjl.library.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @Description 这是
 * @create 2022-02-28 14:55
 */
@Slf4j
public class LoginIntercept implements HandlerInterceptor {

    @Autowired
    UserService userService;
    @Autowired
    AdminService adminService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestURI = request.getRequestURI();
        log.info("捕获的请求有:" + requestURI);

        HttpSession session = request.getSession();
        User loginUser = (User) session.getAttribute("loginUser");
        boolean userExist = userService.checkUserExist(loginUser);
        Admin loginAdmin = (Admin) session.getAttribute("loginAdmin");
        boolean adminExist = adminService.checkAdminExist(loginAdmin);

        //放行
        if ((loginUser != null & userExist) || (loginAdmin != null & adminExist)) {
            return true;
            //拦截
        } else {
            //提示错误信息,并重定向到登录页
            session.removeAttribute("loginUser");
            request.setAttribute("msg", "请先登录");
            request.getRequestDispatcher("/login").forward(request, response);
            return false;
        }
    }
}
