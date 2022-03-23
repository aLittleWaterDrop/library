package com.wjl.library.intercept;

import com.wjl.library.bean.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @Description 这是
 * @create 2022-03-04 10:24
 */
@Slf4j
public class TourIntercept implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        User loginUser = (User) session.getAttribute("loginUser");
        if (loginUser == null) {
            log.info("TourIntercept初始化了一个游客");
            User tourUser = new User();
            tourUser.setUsername("游客");
            session.setAttribute("loginUser", tourUser);
        }

        return true;
    }
}
