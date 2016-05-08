package com.filter;
import com.beans.User;
import com.utils.PermissionUtils;
import org.hibernate.collection.internal.PersistentMap;
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

        // 获得用户请求的URI
        String path = servletRequest.getRequestURI();
        int type=0;
        if(path.indexOf("student")>-1){
            type=1;
        }else if(path.indexOf("teacher")>-1){
            type=2;
        }
        long now= new Date().getTime();
        long begin=now;
        long end=now;
        try {
            Map permissionMap = PermissionUtils.getPermissionMap(servletRequest,type);
            int permissionType=PermissionUtils.checkType(path);
            System.out.println("permissionType:"+permissionType);
            if (permissionType!=-1) {
                String section = (String) permissionMap.get(permissionType);
                begin = Long.parseLong(section.split(":")[0]);
                end = Long.parseLong(section.split(":")[1]);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        if (begin<=now && now<=end) {
            chain.doFilter(request, response);
        } else {
            servletResponse.sendRedirect("/error.jsp");

        }

    }

    public void destroy() {
        // TODO Auto-generated method stub

    }
}
