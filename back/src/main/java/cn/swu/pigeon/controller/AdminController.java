package cn.swu.pigeon.controller;


import cn.swu.pigeon.entity.User;
import cn.swu.pigeon.service.AdminService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin //允许跨域
@RequestMapping("admin")
@Slf4j
public class AdminController {

    @Autowired
    private AdminService adminService;

    /**
     * 处理管理员登录
     */
    @PostMapping("login")
    public Map<String,Object> login(@RequestBody User user, HttpServletRequest request){
        log.info("当前登录用户的信息: [{}]",user.toString());
        Map<String, Object> map =  new HashMap<>();
        try {
            User adminDB = adminService.login(user);
            //广播：一个变量
            request.getServletContext().setAttribute("thisAdmin", adminDB);
            map.put("status",0);
            map.put("msg","登录成功!");
            map.put("data",adminDB);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("status",1);
            map.put("msg",e.getMessage());
            map.put("data",null);
        }
        return map;
    }



    /**
     * 统计操作
     */
    /**
     * 1.签到统计
     */

    /**
     * 2.表单统计
     */

    /**
     * 3.请假统计
     */

    /**
     * 活动管理
     */
}
