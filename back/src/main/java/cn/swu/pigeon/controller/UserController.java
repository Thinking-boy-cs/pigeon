package cn.swu.pigeon.controller;

import cn.swu.pigeon.entity.Record;
import cn.swu.pigeon.entity.User;
import cn.swu.pigeon.service.ChangeInfoService;
import cn.swu.pigeon.service.UserService;
import cn.swu.pigeon.utils.VerifyCodeUtils;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Base64Utils;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin //允许跨域
@RequestMapping("user")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private ChangeInfoService changeInfoService;


    /**
     * 用来处理用户登录
     */
    @PostMapping("login")
    public Map<String,Object> login(@RequestBody User user,HttpServletRequest request){
        log.info("当前登录用户的信息: [{}]",user.toString());
        //广播：一个变量
        request.getServletContext().setAttribute("thisUser", user);
        Map<String, Object> map =  new HashMap<>();
        try {
            User userDB = userService.login(user);
            map.put("status",0);
            map.put("msg","登录成功!");
            map.put("user",userDB);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("status",1);
            map.put("msg",e.getMessage());
        }
        return map;
    }

    /**
     * 用来处理用户注册方法
     */
    @PostMapping("register")
    public Map<String, Object> register(@RequestBody User user, String code, HttpServletRequest request){
        log.info("用户信息:[{}]",user.toString());
        log.info("用户输入的验证码信息:[{}]",code);
        Map<String, Object> map = new HashMap<>();
        try {
            String key = (String) request.getServletContext().getAttribute("code");
            if (key.equalsIgnoreCase(code)) {
                //1.调用业务方法
                userService.register(user);
                map.put("status", 0);
                map.put("msg", "提示: 注册成功!");
            } else {
                throw new RuntimeException("验证码出现错误!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            map.put("status", 1);
            map.put("msg", "提示:"+e.getMessage());
        }
        return map;
    }

    /**
     * 生成验证码图片
     */
    @GetMapping("getImage")
    public String getImageCode(HttpServletRequest request) throws IOException {
        //1.使用工具类生成验证码
        String code = VerifyCodeUtils.generateVerifyCode(4);
        //2.将验证码放入servletContext作用域
        request.getServletContext().setAttribute("code", code);
        //3.将图片转为base64
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        VerifyCodeUtils.outputImage(120, 30, byteArrayOutputStream, code);
        return "data:image/png;base64," + Base64Utils.encodeToString(byteArrayOutputStream.toByteArray());
    }

    /**
     * 设置用户个人信息
     */
    @PostMapping("changeInfo")
    public Map<String,Object> changeUserInfo(@RequestBody User user,HttpServletRequest request){
        log.info("当前签到的用户信息：[{}]",user.toString());
        User thisUser = (User)request.getServletContext().getAttribute("thisUser");
        Map<String,Object> map = new HashMap<>();
        try {
            if(!ObjectUtils.isEmpty(user)){
                thisUser.setIcon(user.getIcon());
                changeInfoService.changeUserInfo(thisUser);
                map.put("status",0);
                map.put("msg","修改成功");
            } else {
                map.put("status",1);
                map.put("msg","修改失败");
            }
            return map;
        } catch (Exception e){
            e.printStackTrace();
            map.put("status",1);
            map.put("msg","修改失败");
            return map;
        }

    }

}
