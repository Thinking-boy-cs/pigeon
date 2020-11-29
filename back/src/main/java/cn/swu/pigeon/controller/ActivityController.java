package cn.swu.pigeon.controller;

import cn.swu.pigeon.entity.Activity;
import cn.swu.pigeon.entity.Application;
import cn.swu.pigeon.entity.Record;
import cn.swu.pigeon.entity.User;
import cn.swu.pigeon.service.ActivityService;
import cn.swu.pigeon.service.ApplicationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin //允许跨域
@RequestMapping("application")
@Slf4j
public class ActivityController {

    @Autowired
    private ApplicationService applicationService;
    @Autowired
    private ActivityService activityService;
    
    @RequestMapping("sign")
    public Map<String,Object> sign(@RequestParam String activityId, HttpServletRequest request){
        User thisUser = (User) request.getSession().getAttribute("thisUser");
        Map<String,Object> map = new HashMap<>();
        try {
            if(!ObjectUtils.isEmpty(thisUser)){
                activityService.sign(activityId, thisUser.getId());
                map.put("status",0);
                map.put("msg","提交成功");
            } else {
                map.put("status",1);
                map.put("msg","提交失败");
            }
            return map;
        } catch (Exception e){
            e.printStackTrace();
            map.put("status",1);
            map.put("msg","提交失败");
            return map;
        }
    }
    /**
     * 处理提交活动
     */
    @PostMapping("submit")
    public Map<String,Object> submit(@RequestBody Application application, HttpServletRequest request){
        User thisUser = (User) request.getSession().getAttribute("thisUser");
        Map<String,Object> map = new HashMap<>();
        try {
            if(!ObjectUtils.isEmpty(application)){
                application.setApplicant(thisUser.getId());
                applicationService.submitApplication(application);
                map.put("status",0);
                map.put("msg","提交成功");
            } else {
                map.put("status",1);
                map.put("msg","提交失败");
            }
            return map;
        } catch (Exception e){
            e.printStackTrace();
            map.put("status",1);
            map.put("msg","提交失败");
            return map;
        }

    }

    /**
     * 处理撤销活动
     */
    @RequestMapping("backout")
    @SuppressWarnings("unchecked")
    public Map<String,Object> backout(@RequestBody int activityId,HttpServletRequest request){
        Map<String,Object> map = new HashMap<>();
        List<Application> thisActivities = (List<Application>)request.getSession().getAttribute("thisActivities");
        try {
            if(activityId!=0){
                for(int i = 0;i<thisActivities.size();i++){
                    if(thisActivities.get(i).getId()==activityId){
                        applicationService.backApplication(activityId);
                        map.put("status",0);
                        map.put("msg","撤销成功");
                    }else{
                        map.put("status",1);
                        map.put("msg","撤销失败");
                    }
                }

            } else {
                map.put("status",1);
                map.put("msg","撤销失败");
            }
            return map;
        } catch (Exception e){
            e.printStackTrace();
            map.put("status",1);
            map.put("msg","撤销失败");
            return map;
        }

    }

    /**
     * 查看活动
     */
    @RequestMapping("find")
    public Map<String,Object> find(HttpServletRequest request){
        Map<String,Object> map = new HashMap<>();
        User thisUser = (User) request.getSession().getAttribute("thisUser");
        try {
            if(!ObjectUtils.isEmpty(thisUser)){
                //返回一个Activity数组
                List<Application> thisActivities = applicationService.findApplication(thisUser.getId());
                request.getSession().setAttribute("thisActivities", thisActivities);
                //System.out.println("所有的活动："+thisActivities.toString());
                for(int i=0;i<thisActivities.size();i++){
                    System.out.println(thisActivities.get(i).getActivityName());
                }
                map.put("status",0);
                map.put("msg","查看成功");
                map.put("data",thisActivities);
            } else {
                map.put("status",1);
                map.put("msg","查看失败");
                map.put("data",null);
            }
            return map;
        } catch (Exception e){
            e.printStackTrace();
            map.put("status",1);
            map.put("msg","查看失败");
            map.put("data",null);
            return map;
        }

    }
    @RequestMapping("getById")
    public Map<String,Object> getById(HttpServletRequest request, @RequestParam String id) {
        Map<String,Object> map = new HashMap<>();
        // User thisUser = (User) request.getSession().getAttribute("thisUser");
        try {
            // if(!ObjectUtils.isEmpty(thisUser)){
                Activity activity = activityService.getById(id);
                map.put("status",0);
                map.put("msg","查看成功");
                map.put("data", activity);
            // } else {
            //     map.put("status",1);
            //     map.put("msg","查看失败，未登录");
            //     map.put("data",null);
            // }
            
        } catch (Exception e){
            e.printStackTrace();
            map.put("status",1);
            map.put("msg","查看失败");
            map.put("data",null);
            return map;
        }
        return map;
    }
    @RequestMapping("getStatus")
    public Map<String,Object> getStatus(HttpServletRequest request, @RequestParam String activityId) {
        Map<String,Object> map = new HashMap<>();
        User thisUser = (User) request.getSession().getAttribute("thisUser");
        try {
            if(!ObjectUtils.isEmpty(thisUser)){
                Integer result = activityService.getStatus(activityId, thisUser.getId());

                
                map.put("status",0);
                map.put("msg","查看成功");
                map.put("data", result);
            } else {
                map.put("status",1);
                map.put("msg","查看失败");
                map.put("data",null);
            }
            
        } catch (Exception e){
            e.printStackTrace();
            map.put("status",1);
            map.put("msg","查看失败");
            map.put("data",null);
            return map;
        }
        return map;
    }
    @RequestMapping("getRecordsById")
    public Map<String,Object> getRecordsById(HttpServletRequest request, @RequestParam String id) {
        Map<String,Object> map = new HashMap<>();
        User thisUser = (User) request.getSession().getAttribute("thisUser");
        try {
            if(!ObjectUtils.isEmpty(thisUser)){
                List<Record> records = activityService.getRecordsById(id);

                for(int i=0;i<records.size();i++){
                    System.out.println(records.get(i).getStatus());
                }
                map.put("status",0);
                map.put("msg","查看成功");
                map.put("data", records);
            } else {
                map.put("status",1);
                map.put("msg","查看失败");
                map.put("data",null);
            }
            
        } catch (Exception e){
            e.printStackTrace();
            map.put("status",1);
            map.put("msg","查看失败");
            map.put("data",null);
            return map;
        }
        return map;
    }
    @RequestMapping("getByUserId")
    public Map<String,Object> getByUserId(HttpServletRequest request, @RequestParam String userId) {
        Map<String,Object> map = new HashMap<>();
        User thisUser = (User) request.getSession().getAttribute("thisUser");
        try {
            if(!ObjectUtils.isEmpty(thisUser)){
                List<Activity> activities = activityService.getByUserId(thisUser.getId());

                for(int i=0;i<activities.size();i++){
                    System.out.println(activities.get(i).getName());
                }
                map.put("status",0);
                map.put("msg","查看成功");
                map.put("data", activities);
            } else {
                map.put("status",1);
                map.put("msg","查看失败");
                map.put("data",null);
            }
            
        } catch (Exception e){
            e.printStackTrace();
            map.put("status",1);
            map.put("msg","查看失败");
            map.put("data",null);
            return map;
        }
        return map;
    }
}
