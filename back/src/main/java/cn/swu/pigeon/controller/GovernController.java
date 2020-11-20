package cn.swu.pigeon.controller;

import cn.swu.pigeon.entity.User;
import cn.swu.pigeon.service.GovernService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 对用户的操作
 */
@RestController
@CrossOrigin //允许跨域
@RequestMapping("govern")
@Slf4j
public class GovernController {

    @Autowired
    GovernService governService;
    /**
     * 1.查看所有用户
     */
    @RequestMapping("find")
    public Map<String,Object> find(HttpServletRequest request){

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
     * 2.修改用户信息
     */

    /**
     * 3.添加用户信息
     */

    /**
     * 4.删除用户信息
     */
}
