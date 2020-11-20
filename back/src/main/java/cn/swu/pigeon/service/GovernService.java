package cn.swu.pigeon.service;

import cn.swu.pigeon.entity.User;

import java.util.List;

public interface GovernService {
    //管理员查看用户信息
    List<User> findUsers();
}
