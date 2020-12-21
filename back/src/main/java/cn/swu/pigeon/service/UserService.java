package cn.swu.pigeon.service;

import cn.swu.pigeon.entity.User;

import java.util.Map;

public interface UserService {

    //用户注册
    void register(User user);

    //用户登录
    Map login(User user);

    //用户查询个人信息
    //User find(User user);

    //请求短信验证码
    String sendSMS(String phoneNumber);
    Map find(User user);
}
