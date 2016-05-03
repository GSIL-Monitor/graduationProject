package com.utils;

import com.beans.Report;
import com.beans.User;
import com.opensymphony.xwork2.ActionContext;
import org.apache.struts2.ServletActionContext;

import java.io.*;

/**
 * Created by wuhao on 16/4/28.
 */
public class FileUtils {
    public static void saveFile(String fileName,File docFile) throws Exception{
        User user= (User) ActionContext.getContext().getSession().get("user");
        String path = ServletActionContext.getServletContext().getRealPath("/WEB-INF/upload");
        String filename = path + File.separator +fileName;
        File file=new File(filename);
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
        File file=new File(filename);
        if(!file .exists()  && !file .isDirectory())
        {
            file .mkdir();
        }
        FileInputStream in = new FileInputStream(value);
        FileOutputStream out = new FileOutputStream(filename);
        byte[] b = new byte[1024];
        int len = 0;
        while ((len = in.read(b)) > 0) {
            out.write(b, 0, len);
        }
        out.close();
    }
    public static String getper(String type) throws Exception{
        String path = ServletActionContext.getServletContext().getRealPath("/WEB-INF/permission");
        String filename = path + File.separator +type;
        StringBuffer buffer=new StringBuffer();
        File file=new File(filename);
        if(!file .exists()  && !file .isDirectory())
        {
            file .mkdir();
        }
        Reader reader = new InputStreamReader(new FileInputStream(file));
        int tempchar;
        while ((tempchar = reader.read()) != -1) {
            buffer.append((char) tempchar);
        }
        reader.close();
        return buffer.toString();
    }
}
