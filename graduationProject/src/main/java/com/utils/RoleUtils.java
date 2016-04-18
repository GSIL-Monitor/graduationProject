package com.utils;

/**
 * Created by wuhao on 16/4/17.
 */
public class RoleUtils {
    public static String checkRoleType(int type){
        if (type==1){
            return "STUDENT";
        }else if (type==2) {
            return "TEACHER";
        }
        return "ADMIN";
    }

}
