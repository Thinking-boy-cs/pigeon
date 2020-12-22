package cn.swu.pigeon.service;

import cn.swu.pigeon.entity.User;

import java.util.Map;

public interface UserService {

    //用户注册
    void register(User user);

    //用户登录
    Map login(User user);

    //用户查询个人信息
    Map find(User user);

    User findUser(User user);
}
