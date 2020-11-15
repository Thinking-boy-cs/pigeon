package cn.swu.pigeon.service;

import cn.swu.pigeon.entity.User;

public interface UserService {

    //用户注册
    void register(User user);

    //用户登录
    User login(User user);
}
