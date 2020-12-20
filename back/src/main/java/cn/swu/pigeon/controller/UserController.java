package cn.swu.pigeon.controller;

import cn.swu.pigeon.entity.Record;
import cn.swu.pigeon.entity.RequestType;
import cn.swu.pigeon.entity.User;
import cn.swu.pigeon.service.ChangeInfoService;
import cn.swu.pigeon.service.UserService;
import cn.swu.pigeon.utils.VerifyCodeUtils;
import lombok.extern.slf4j.Slf4j;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Base64Utils;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin // 允许跨域
@RequestMapping("user")
@Slf4j
public class UserController {

    @Resource
    @Autowired
    private UserService userService;

    @Autowired
    private ChangeInfoService changeInfoService;

    /**
     * 处理用户登录
     */
    @PostMapping("login")
    public Map<String, Object> login(@RequestBody User user, HttpServletRequest request) {
        log.info("当前登录用户的信息1: [{}]", user.toString());
        log.info("in login sessionid: " + request.getSession().getId());
        System.out.println(request.getContextPath());
        System.out.println(request.getServletPath());
        Map<String, Object> map = new HashMap<>();
        try {
            User userDB = userService.login(user);
            //广播：一个变量
            User thisUser = userService.find(user);
            request.getSession().setAttribute("thisUser", thisUser);
            log.info("当前登录用户的信息2: [{}]", thisUser.toString());
            map.put("status",0);
            map.put("msg","登录成功!");
            map.put("data",userDB);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("status", 1);
            map.put("msg", e.getMessage());
            map.put("data", null);
        }
        return map;
    }

    /**
     * 用来处理用户注册方法
     */
    @PostMapping("register")
    public Map<String, Object> register(@RequestParam @RequestBody User user,@RequestParam String code, String thisPassword,
            HttpServletRequest request) {
        log.info("用户信息:[{}]", user.toString());
        log.info("用户输入的验证码信息:[{}]", code);
        log.info("用户确认的密码:[{}]", thisPassword);
        Map<String, Object> map = new HashMap<>();
        try {
            HttpSession session = request.getSession(false); 
            String key = "";
            if(session != null)
            {
              key = (String)session.getAttribute("code");
              log.info("Current Key", key);
            } else {
              log.info("Session Not Exists");
            }
            if ( key != "" && key.equalsIgnoreCase(code)) {
                // 1.调用业务方法
                userService.register(user);
                map.put("status", 0);
                map.put("msg", "提示: 注册成功!");
            } else {
                throw new RuntimeException("验证码出现错误!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            map.put("status", 1);
            map.put("msg", "提示:" + e.getMessage());
        }
        return map;
    }


    @PostMapping("register1")
    public Map<String, Object> register1(@RequestBody RequestType req, HttpServletRequest request) {
        log.info("用户信息:[{}]", req.getData().toString());
        log.info("用户输入的验证码信息:[{}]", req.getCode());
        Map<String, Object> map = new HashMap<>();
        try {
            HttpSession session = request.getSession(); 
            String key = "";
            if(session != null)
            {
              log.info("in regist sessionid: " + request.getSession().getId());

              key = (String)session.getAttribute("code");
              log.info("Current Key", key);
            } else {
              log.info("Session Not Exists");
            }
            if ( key != "" && key.equalsIgnoreCase(req.getCode())) {
                // 1.调用业务方法
                userService.register(req.getData());
                map.put("status", 0);
                map.put("msg", "提示: 注册成功!");
            } else {
                throw new RuntimeException("验证码出现错误!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            map.put("status", 1);
            map.put("msg", "提示:" + e.getMessage());
        }
        return map;
    }

    /**
     * 生成验证码图片
     */
    @GetMapping("getImage")
    public String getImageCode(HttpServletRequest request) throws IOException {
        // 1.使用工具类生成验证码
        String code = VerifyCodeUtils.generateVerifyCode(4);
        log.info("Current key: " + code);
        //2.将验证码放入servletContext作用域
        request.getSession().setAttribute("code", code);
        log.info("sessionid: " + request.getSession().getId());
        //3.将图片转为base64
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        VerifyCodeUtils.outputImage(120, 30, byteArrayOutputStream, code);
        return "data:image/png;base64," + Base64Utils.encodeToString(byteArrayOutputStream.toByteArray());
    }

    /**
     * 查看用户个人信息
     */
    @RequestMapping("find")
    public Map<String,Object> find(HttpServletRequest request){
        Map<String, Object> map =  new HashMap<>();
        User thisUser = (User)request.getSession().getAttribute("thisUser");
        try {
            userService.find(thisUser);
            map.put("status",0);
            map.put("msg","查看成功!");
            map.put("data",thisUser);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("status", 1);
            map.put("msg", e.getMessage());
            map.put("data", null);
        }
        return map;
    }

    /**
     * 设置用户个人信息
     */
   @RequestMapping(value = "/changeUserInfo" ,method = RequestMethod.POST)
//    @ResponseBody
    //@RequestMapping("changeUserInfo")
    public Map<String,Object> changeUserInfo( User user, HttpServletRequest request, MultipartFile multipartFile){
        log.info("当前签到的用户信息：[{}]",user.toString());
        User thisUser = (User)request.getSession().getAttribute("thisUser");
        log.info("[{}]",thisUser.toString());
        Map<String,Object> map = new HashMap<>();
        log.info("[{}]",multipartFile);

        try {
            if (multipartFile.isEmpty()) {
                map.put("status", 1);
                map.put("msg", "文件不存在");
            }
            if (!ObjectUtils.isEmpty(user)) {
                // 修改信息
                if(!user.getSex().equals("")){
                    thisUser.setSex(user.getSex());
                }
                if(!user.getTelNumber().equals("")){
                    thisUser.setTelNumber(user.getTelNumber());
                }
                if(!user.getEmail().equals("")){
                    thisUser.setEmail(user.getEmail());
                }
                if(!user.getSignature().equals("")){
                    thisUser.setSignature(user.getSignature());
                }
                if(!user.getSignature().equals("")){
                    thisUser.setHometown(user.getHometown());
                }
                log.info("修改性别后当前用户：[{}]",thisUser.toString());
//                changeInfoService.changeUserInfo(thisUser);
                changeInfoService.changeUserInfo(multipartFile,thisUser);
                //更新广播
                request.getSession().setAttribute("thisUser", thisUser);
                map.put("status",0);
                map.put("msg","修改成功");
            } else {
                map.put("status", 1);
                map.put("msg", "修改失败");
            }
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            map.put("status", 1);
            map.put("msg", "修改失败");
            return map;
        }

    }

    /**
     * 请求发送短信验证码
     * @param request
     * @return
     */
    @RequestMapping("sendSMS")
    public Map<String,Object> sendSMS(HttpServletRequest request){
        Map<String, Object> map =  new HashMap<>();
        User thisUser = (User)request.getSession().getAttribute("thisUser");
        try {
            String messageCode = userService.sendSMS(thisUser.getTelNumber());
            map.put("status",0);
            map.put("msg","发送成功!");
            map.put("smsCode",messageCode);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("status", 1);
            map.put("msg", e.getMessage());
            map.put("smsCode",null);
        }
        return map;
    }

}
