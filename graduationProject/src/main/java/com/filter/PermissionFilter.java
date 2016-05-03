package com.filter;
import com.beans.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;
import java.util.Map;
import java.util.zip.DataFormatException;

/**
 * Created by wuhao on 16/4/16.
 */
public class PermissionFilter implements Filter {
    private static final Logger logger = LoggerFactory.getLogger(PermissionFilter.class);
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

        String permissionType=request.getParameter("permissionType");
        if (permissionType==null){
            chain.doFilter(request, response);
        }else{
            Map permissionMap = (Map)session.getAttribute("permissionMap");
            long now= new Date().getTime();
            String  section=(String)permissionMap.get(permissionType);
            long begin = Long.parseLong(section.split(":")[0]);
            long end = Long.parseLong(section.split(":")[1]);
            if (begin<now && now<end) {
                servletResponse.sendRedirect("/error.jsp");
            } else {
                // 已经登陆,继续此次请求
                chain.doFilter(request, response);
            }
        }

    }

    public void destroy() {
        // TODO Auto-generated method stub

    }
}
