package com.filter;
import com.beans.User;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by wuhao on 16/4/16.
 */
public class LoginFilter implements Filter {
    private static final Logger logger = LoggerFactory.getLogger(LoginFilter.class);

    public void init(FilterConfig filterConfig) throws ServletException {
        // TODO Auto-generated method stub

    }

    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        // 获得在下面代码中要用的request,response,session对象
        HttpServletRequest servletRequest = (HttpServletRequest) request;
        HttpServletResponse servletResponse = (HttpServletResponse) response;
        HttpSession session = servletRequest.getSession();

        // 获得用户请求的URI
        String path = servletRequest.getRequestURI();
        logger.info("path:"+path);
        //System.out.println(path);

        // 从session里取
        User user = (User) session.getAttribute("user");
        // 登陆页面无需过滤
        if(path.indexOf("/login.jsp") > -1) {
            chain.doFilter(servletRequest, servletResponse);
            return;
        }
        if(path.indexOf("userAction_login") > -1) {
            chain.doFilter(servletRequest, servletResponse);
            return;
        }
        if(path.indexOf("userAction_recover") > -1) {
            chain.doFilter(servletRequest, servletResponse);
            return;
        }

        if (user == null && (path.indexOf("Action")!=-1 ||path.indexOf("jsp")!=-1)) {
            // 跳转到登陆页面
            servletResponse.sendRedirect("/login.jsp");
        } else {
            // 已经登陆,继续此次请求
            chain.doFilter(request, response);
        }

    }

    public void destroy() {
        // TODO Auto-generated method stub

    }
}
