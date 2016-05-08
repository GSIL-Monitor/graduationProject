package com.utils;

import com.beans.Topic;
import com.beans.TopicCheckProcess;
import com.beans.TopicProcess;
import com.beans.TopicStatus;
import net.sf.json.JSONObject;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by wuhao on 16/4/17.
 */
public class PermissionUtils {
   public static Map getPermissionMap(HttpServletRequest request,int type) throws Exception{
       Map permissionMap =new HashMap();
       if (type==2) {
           String teacherPermission = FileUtils.getper("teacher", request);
           TopicCheckProcess topicCheckProcess = (TopicCheckProcess) JSONObject.toBean(JSONObject.fromObject(teacherPermission), TopicCheckProcess.class);

           permissionMap.put(0, topicCheckProcess.getTopicCommitBegin().getTime() + ":" + topicCheckProcess.getTopicCommitEnd().getTime());
           permissionMap.put(1, topicCheckProcess.getChoiceBegin().getTime() + ":" + topicCheckProcess.getChoiceEnd().getTime());
           permissionMap.put(2, topicCheckProcess.getTopicBegin().getTime() + ":" + topicCheckProcess.getTopicEnd().getTime());
           permissionMap.put(3, topicCheckProcess.getTopicMidBegin().getTime() + ":" + topicCheckProcess.getTopicMidEnd().getTime());
           permissionMap.put(4, topicCheckProcess.getTopicFinalBegin().getTime() + ":" + topicCheckProcess.getTopicFinalEnd().getTime());
       }else if(type==1){
           String studentPermission = FileUtils.getper("student", request);
           TopicProcess topicProcess=(TopicProcess) JSONObject.toBean(JSONObject.fromObject(studentPermission), TopicProcess.class);

           permissionMap.put(1, topicProcess.getChoiceBegin().getTime() + ":" + topicProcess.getChoiceEnd().getTime());
           permissionMap.put(2, topicProcess.getTopicBegin().getTime() + ":" + topicProcess.getTopicEnd().getTime());
           permissionMap.put(3, topicProcess.getTopicMidBegin().getTime() + ":" + topicProcess.getTopicMidEnd().getTime());
           permissionMap.put(4, topicProcess.getTopicFinalBegin().getTime() + ":" + topicProcess.getTopicFinalEnd().getTime());

       }
       return permissionMap;
   }
    public static int checkType(String path){
        Map<String,Integer> tmpMap=new HashMap();
        tmpMap.put("add",0);
        tmpMap.put("updateTopic",0);
        tmpMap.put("studentTopic",1);
        tmpMap.put("choice",1);
        tmpMap.put("begin",2);
        tmpMap.put("mid",3);
        tmpMap.put("topFinal",4);
        if(path.indexOf("Read")>-1){
            return -1;
        }
        for (String key : tmpMap.keySet()) {
            if (path.indexOf(key)>-1){
                return tmpMap.get(key);
            }
        }
        return -1;
    }
}
