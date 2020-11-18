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


    /**
     * 查看活动
     */
}
