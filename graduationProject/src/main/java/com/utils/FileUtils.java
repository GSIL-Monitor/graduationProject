package com.utils;

import com.beans.Report;
import com.beans.User;
import com.opensymphony.xwork2.ActionContext;
import org.apache.struts2.ServletActionContext;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.*;

/**
 * Created by wuhao on 16/4/28.
 */
public class FileUtils {
    public static void saveFile(String fileName,File docFile) throws Exception{
        User user= (User) ActionContext.getContext().getSession().get("user");
        String path = ServletActionContext.getServletContext().getRealPath("/WEB-INF/upload");
        String filename = path + File.separator +fileName;
        File file=new File(path);
        if(!file .exists()  && !file .isDirectory())
        {
            file .mkdir();
        }
        FileInputStream in = new FileInputStream(docFile);
        FileOutputStream out = new FileOutputStream(filename);
        byte[] b = new byte[1024];
        int len = 0;
        while ((len = in.read(b)) > 0) {
            out.write(b, 0, len);
        }
        out.close();
    }
    public static InputStream getFile(String fileName) throws Exception {
        String path= ServletActionContext.getServletContext().getRealPath("/WEB-INF/upload");
        String filename = path + File.separator + fileName;
        return new FileInputStream(new File(filename));

    }
    public static String formatFileName(String fileName){
        User user= (User) ActionContext.getContext().getSession().get("user");
        return user.getUsername()+"_"+fileName;
    }
    public static void saveper(String type,String value) throws Exception{
        String path = ServletActionContext.getServletContext().getRealPath("/WEB-INF/permission");
        String filename = path + File.separator +type;
        File file=new File(path);
        System.out.println("type:" + type + ",value:" + value);
        if(!file .exists()  && !file .isDirectory())
        {
            file .mkdir();
        }else {

        }
        FileOutputStream out = new FileOutputStream(filename);
        out.write(value.getBytes("utf-8"));
        out.close();
    }
    public static String test(String type) throws Exception{
        String path = ServletActionContext.getServletContext().getRealPath("/WEB-INF/permission");
        String filename = path + File.separator +type;
        StringBuffer buffer=new StringBuffer();
        File file=new File(path);
        if(!file .exists()  && !file .isDirectory())
        {
            file .mkdir();
        }
        Reader reader = new InputStreamReader(new FileInputStream(filename));
        int tempchar;
        while ((tempchar = reader.read()) != -1) {
            buffer.append((char) tempchar);
        }
        reader.close();
        return buffer.toString();
    }
    public static String getper(String type,HttpServletRequest request) throws Exception{
        String path = request.getRealPath("/WEB-INF/permission");
        String filename = path + File.separator +type;
        File file=new File(filename);
        if(!file.exists()||file.isDirectory()) {
            throw new FileNotFoundException();
        }
        FileInputStream fis=new FileInputStream(file);
        byte[] buf = new byte[1024];
        StringBuffer sb=new StringBuffer();
        while((fis.read(buf))!=-1){
            sb.append(new String(buf));
            buf=new byte[1024];//重新生成，避免和上次读取的数据重复
        }
        return sb.toString();
    }
}
