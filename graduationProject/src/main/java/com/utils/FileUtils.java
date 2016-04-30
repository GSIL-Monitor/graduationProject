package com.utils;

import com.beans.User;
import com.opensymphony.xwork2.ActionContext;
import org.apache.struts2.ServletActionContext;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

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
}
