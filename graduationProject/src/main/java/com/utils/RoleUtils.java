package com.utils;

import java.util.UUID;

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
    public static String genId() {
        return UUID.randomUUID().toString();
    }

    public static void main(String args[]){
        System.out.print("呵呵哒");

    }

}
