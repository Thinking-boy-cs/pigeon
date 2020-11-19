package cn.swu.pigeon.controller;

import cn.swu.pigeon.entity.Activity;
import cn.swu.pigeon.entity.Record;
import cn.swu.pigeon.entity.User;
import cn.swu.pigeon.service.ActivityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin //允许跨域
@RequestMapping("activity")
@Slf4j
public class ActivityController {

    @Autowired
    private ActivityService activityService;

    /**
     * 处理提交活动
     */
    @PostMapping("submit")
    public Map<String,Object> submit(@RequestBody Activity activity, HttpServletRequest request){
        User thisUser = (User) request.getServletContext().getAttribute("thisUser");
        Map<String,Object> map = new HashMap<>();
        try {
            if(!ObjectUtils.isEmpty(activity)){
                activity.setApplicant(thisUser.getUsername());
                activityService.submitActivity(activity);
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
    @PostMapping("backout")
    //这里有问题：怎么处理不同的活动？---->先写查看活动（要做表的连接）
    public Map<String,Object> backout(@RequestBody Activity activity,HttpServletRequest request){
        Map<String,Object> map = new HashMap<>();
        List<Activity> thisActivities = (List<Activity>) request.getServletContext().getAttribute("thisActivities");
        try {
            if(!ObjectUtils.isEmpty(activity)){
                for(int i = 0;i<thisActivities.size();i++){
                    if(thisActivities.get(i).getId()==activity.getId()){
                        activityService.backActivity(activity);
                    }
                }

                map.put("status",0);
                map.put("msg","撤销成功");
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
    @PostMapping("find")
    public Map<String,Object> find(HttpServletRequest request){
        Map<String,Object> map = new HashMap<>();
        User thisUser = (User) request.getServletContext().getAttribute("thisUser");
        try {
            if(!ObjectUtils.isEmpty(thisUser)){
                //返回一个Activity数组
                List<Activity> thisActivities = activityService.findActivity(thisUser);
                //这个怎么交给前端？？？
                request.getServletContext().setAttribute("thisActivities", thisActivities);
                //System.out.println("所有的活动："+thisActivities.toString());
                map.put("status",0);
                map.put("msg","查看成功");
            } else {
                map.put("status",1);
                map.put("msg","查看失败");
            }
            return map;
        } catch (Exception e){
            e.printStackTrace();
            map.put("status",1);
            map.put("msg","查看失败");
            return map;
        }

    }

}
