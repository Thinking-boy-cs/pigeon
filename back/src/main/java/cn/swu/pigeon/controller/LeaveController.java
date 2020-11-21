package cn.swu.pigeon.controller;

import cn.swu.pigeon.entity.Activity;
import cn.swu.pigeon.entity.Leave;
import cn.swu.pigeon.entity.User;
import cn.swu.pigeon.service.ActivityService;
import cn.swu.pigeon.service.LeaveService;
import cn.swu.pigeon.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin //允许跨域
@RequestMapping("leave")
@Slf4j
public class LeaveController {
    //    @Autowired
//    private ActivityService activityService;
    @Resource
    private LeaveService leaveService;

    /**
     * 处理提交请假
     */
    @PostMapping("submit")
    public Map<String,Object> submit(@RequestBody Leave leave, HttpServletRequest request) {
        User thisUser = (User) request.getSession().getAttribute("thisUser");
        Map<String, Object> map = new HashMap<>();
        try {
            if (!ObjectUtils.isEmpty(leave)) {
                leave.setUserId(thisUser.getId());
//                activityService.submitActivity(activity);

                leaveService.submitLeave(leave);
                map.put("status", 0);
                map.put("msg", "提交成功");
//                return Result.success(leave);
            } else {
                map.put("status", 1);
                map.put("msg", "提交失败");
//                return Result.error();
            }
//            return map;
        } catch (Exception e) {
            e.printStackTrace();
            map.put("status", 1);
            map.put("msg", "提交失败");
//            return Result.error();
        }
        return map;

    }

    /**
     * 处理撤销请假
     */
    @PostMapping("back")
    @SuppressWarnings("unchecked")

    public Map<String,Object> back(@RequestBody Leave leave, HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();
//        List<Activity> thisActivities = (List<Activity>)request.getServletContext().getAttribute("thisActivities");
        List<Leave> thisLeaves = (List<Leave>) request.getSession().getAttribute("thisLeaves");
        try {
            if (!ObjectUtils.isEmpty(leave)) {
                for (int i = 0; i < thisLeaves.size(); i++) {
                    if (thisLeaves.get(i).getId() == leave.getId()) {
//                        activityService.backActivity(activity);
                        leaveService.backLeave(leave);
                        map.put("status", 0);
                        map.put("msg", "撤销成功");
                    } else {
                        map.put("status", 1);
                        map.put("msg", "撤销失败");
                    }
                }

            }else{
                map.put("status", 1);
                map.put("msg", "撤销失败");
            }
//            return map;
        } catch (Exception e) {
            e.printStackTrace();
            map.put("status", 1);
            map.put("msg", "撤销失败");
//            return map;
        }

        return map;
    }

    /**
     * 查看请假
     */
    @RequestMapping("find")
    public Map<String, Object> find(HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();
        User thisUser = (User) request.getSession().getAttribute("thisUser");
        try {
            if (!ObjectUtils.isEmpty(thisUser)) {
                //返回一个Activity数组
//                List<Activity> thisActivities = activityService.findActivity(thisUser);
                List<Leave> thisLeaves = leaveService.findLeave(thisUser);
//                request.getServletContext().setAttribute("thisActivities", thisActivities);
                request.getSession().setAttribute("thisLeaves", thisLeaves);

                //System.out.println("所有的活动："+thisActivities.toString());
                for (int i = 0; i < thisLeaves.size(); i++) {
                    System.out.println(thisLeaves.get(i).getReason());
                }
                map.put("status", 0);
                map.put("msg", "查看成功");
                map.put("data", thisLeaves);
            } else {
                map.put("status", 1);
                map.put("msg", "查看失败");
                map.put("data", null);
            }
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            map.put("status", 1);
            map.put("msg", "查看失败");
            map.put("data", null);
            return map;
        }

    }

}
