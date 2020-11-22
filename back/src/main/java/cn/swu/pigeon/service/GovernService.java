package cn.swu.pigeon.service;

import cn.swu.pigeon.entity.Activity;
import cn.swu.pigeon.entity.Record;
import cn.swu.pigeon.entity.User;

import java.util.Date;
import java.util.List;

public interface GovernService {
    //管理员查看用户信息
    List<User> findUsers();
    //添加用户信息
    void addUser(User user);
    //删除用户信息
    void deleteUser(User user);
    //修改用户信息
    void updateUser(User user);
    //查看活动
    List<Activity> findActivity();
    //审批活动
    void approveActivity(String id,String status);
    //查询某天已签到记录
    List<Record> findSigned(Date theTime);
    //查询某天未签到记录
    List<Record> findUnsigned(Date theTime);
    //查询某天处于请假的记录
    List<Record> findLeave(Date theTime);
}
