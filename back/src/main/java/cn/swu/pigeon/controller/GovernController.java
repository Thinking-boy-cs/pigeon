package cn.swu.pigeon.controller;

import cn.swu.pigeon.entity.Application;
import cn.swu.pigeon.entity.Leave;
import cn.swu.pigeon.entity.Record;
import cn.swu.pigeon.entity.User;
import cn.swu.pigeon.service.GovernService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@CrossOrigin //允许跨域
@RequestMapping("govern")
@Slf4j
public class GovernController {

    @Autowired
    GovernService governService;
    /**
     * 对用户的操作
     */
    /**
     * 1.查看所有用户
     */
    @RequestMapping("findUser")
    public Map<String,Object> find(){

        Map<String, Object> map =  new HashMap<>();
        try {
            List<User> thisUsers = governService.findUsers();
            map.put("status",0);
            map.put("msg","登录成功!");
            map.put("data",thisUsers);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("status",1);
            map.put("msg",e.getMessage());
            map.put("data",null);
        }
        return map;
    }

    /**
     * 2.添加用户信息
     */
    @RequestMapping("addUser")
    public Map<String,Object> addUser(@RequestBody User user,HttpServletRequest request){
        Map<String, Object> map =  new HashMap<>();
        try {
            governService.addUser(user);
            map.put("status",0);
            map.put("msg","添加成功!");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("status",1);
            map.put("msg",e.getMessage());
        }
        return map;
    }
    /**
     * 3.修改用户信息
     */
    @RequestMapping("updateUser")
    public Map<String,Object> updateUser(@RequestBody User user,HttpServletRequest request){
        Map<String, Object> map =  new HashMap<>();
        try {
            governService.updateUser(user);
            map.put("status",0);
            map.put("msg","修改成功!");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("status",1);
            map.put("msg",e.getMessage());
        }
        return map;
    }



    /**
     * 4.删除用户信息
     */
    @RequestMapping("deleteUser")
    public Map<String,Object> deleteUser(@RequestBody User user,HttpServletRequest request){
        Map<String, Object> map =  new HashMap<>();
        try {
            governService.deleteUser(user);
            map.put("status",0);
            map.put("msg","删除成功!");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("status",1);
            map.put("msg",e.getMessage());
        }
        return map;
    }

    /**
     * 5.查询特定用户信息
     */
    @RequestMapping("queryUser")
    public Map<String,Object> queryUser(@RequestBody String userId,HttpServletRequest request){
        Map<String, Object> map =  new HashMap<>();
        try {
            User u = governService.queryUser(userId);
            map.put("status",0);
            map.put("data",u);
            map.put("msg","查询成功!");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("status",1);
            map.put("msg",e.getMessage());
        }
        return map;
    }

    /**
     * 对签到的操作
     */

    /**
     * 1.已签到/未签到/请假全表查看（根据时间）
     * 三个分开写
     */

    /**
     * 1.1已签到记录
     */
    @RequestMapping("findSigned")
    public Map<String,Object> findSigned(Date theTime){

        Map<String, Object> map =  new HashMap<>();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String sDate = simpleDateFormat.format(theTime);
//        String sDate = "2020-12-14";
        try {
            List<Record> thisSigned = governService.findSigned(sDate);
            map.put("status",0);
            map.put("msg","查询成功!");
            map.put("data",thisSigned);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("status",1);
            map.put("msg",e.getMessage());
            map.put("data",null);
        }
        return map;
    }

    /**
     * 1.2未签到记录
     */
    @RequestMapping("findUnsigned")
    public Map<String,Object> findUnsigned(Date theTime){

        Map<String, Object> map =  new HashMap<>();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String sDate = simpleDateFormat.format(theTime);
//        String sDate = "2020-12-14";
        try {
            List<User> thisUnsigned = governService.findUnsigned(sDate);
            map.put("status",0);
            map.put("msg","查询成功!");
            map.put("data",thisUnsigned);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("status",1);
            map.put("msg",e.getMessage());
            map.put("data",null);
        }
        return map;
    }

    /**
     * 1.3请假记录
     */
    @RequestMapping("findLeaved")
    public Map<String,Object> findLeaved(Date theTime){

        Map<String, Object> map =  new HashMap<>();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String sDate = simpleDateFormat.format(theTime);
//        String sDate = "2020-12-14";
        try {
            List<Leave> thisLeave = governService.findLeaved(sDate);
            map.put("status",0);
            map.put("msg","查询成功!");
            map.put("data",thisLeave);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("status",1);
            map.put("msg",e.getMessage());
            map.put("data",null);
        }
        return map;
    }



    /**
     * 对活动的操作
     */

    /**
     * 1.审批（通过/拒绝）
     */
    @RequestMapping("approveActivity")
    public Map<String,Object> approveActivity(String id ,String status){
        Map<String, Object> map =  new HashMap<>();
        try {
            //测试
            id="1";
            status="已通过";
            governService.approveApplication(id,status);
            map.put("status",0);
            map.put("msg","审批成功!");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("status",1);
            map.put("msg",e.getMessage());
        }
        return map;
    }

    /**
     * 2.查看所有活动（结束/进行中）
     */
    @RequestMapping("findActivity")
    public Map<String,Object> findActivity(){
        Map<String, Object> map =  new HashMap<>();
        try {
            List<Application> thisActivities = governService.findApplication();
            map.put("status",0);
            map.put("msg","查看成功!");
            map.put("data",thisActivities);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("status",1);
            map.put("msg",e.getMessage());
            map.put("data",null);
        }
        return map;
    }

    /**
     * 对请假的操作
     */
    /**
     * 1.审批
     */
    @RequestMapping("approveLeave")
    public Map<String,Object> approveLeave(String id ,String status){
        Map<String, Object> map =  new HashMap<>();
        try {
            //测试
            id="1";
            status="已通过";
            governService.approveLeave(id,status);
            map.put("status",0);
            map.put("msg","审批成功!");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("status",1);
            map.put("msg",e.getMessage());
        }
        return map;
    }

    /**
     * 统计已签到的人数
     * @return
     */
    @RequestMapping("countSigned")
    public Map<String,Object> countSigned(Date date){
        Map<String,Object> map = new HashMap<>();
//        date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String sDate = simpleDateFormat.format(date);
//        System.out.println(sDate);
//        String sDate = "2020-12-14";
        try{

            int sum = governService.cSigned(sDate);
            map.put("status",0);
            map.put("msg","查询成功");
            map.put("data",sum);
        }catch (Exception e){

            e.printStackTrace();
            map.put("status",1);   
            map.put("msg",e.getMessage());
            map.put("data",null);
        }
        return map;
    }

    @RequestMapping("countUnsigned")
    public Map<String,Object> countUnsigned(Date date){
        Map<String,Object> map = new HashMap<>();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String sDate = simpleDateFormat.format(date);

        try{
            int sum = governService.cUnsigned(sDate);
            map.put("status",0);
            map.put("msg","查询成功");
            map.put("data",sum);

        }catch (Exception e){
            e.printStackTrace();
            map.put("status",1);
            map.put("msg",e.getMessage());
            map.put("data",null);
        }
        return map;
    }



    /**
     * 发信息收集表单（调用大厂接口API）
     */

    /**
     * 1.方案一：模板
     */

    /**
     * 2.方案二：动态自定义
     */

    /**
     * 发通知
     */
}
