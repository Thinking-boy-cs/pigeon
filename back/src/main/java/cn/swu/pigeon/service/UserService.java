package cn.swu.pigeon.service;

import cn.swu.pigeon.entity.User;

public interface UserService {

    //用户注册
    void register(User user);

    //用户登录
    User login(User user);

    //用户查询个人信息
    User find(User user);
}
