package com.utils;

import com.beans.Topic;
import com.beans.TopicStatus;
import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
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
        Topic topic=new Topic();
        String test=JSONObject.fromObject(topic).toString();
        System.out.println(test);

    }
    public static double countScore(TopicStatus topicStatus){
        if(topicStatus.getTopicBegin()==2 && topicStatus.getTopicMid()==2 &&topicStatus.getTopicFinal()==2){
            return topicStatus.getBeginScore()*0.2+topicStatus.getMidScore()*0.3+topicStatus.getFinalScore()*0.5;
        }else {
            return 0;
        }
    }
    public static String transcoding(String str) {
        try {
            return new String(str.getBytes("utf-8"), "iso-8859-1");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return str;
    }
    public static String covent(int status){
        Map<Integer,String> map=new HashMap();
        map.put(0,"未提交");
        map.put(1,"提交未审核");
        map.put(2,"审核已通过");
        return map.get(status);
    }

}
