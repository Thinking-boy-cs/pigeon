package cn.swu.pigeon.service;

import cn.swu.pigeon.entity.Activity;
import cn.swu.pigeon.entity.Record;
import cn.swu.pigeon.entity.User;

import java.util.Date;
import java.util.List;

public interface GovernService {
    /**
     * 用户管理
     * @return
     */
    //管理员查看用户信息
    List<User> findUsers();
    //添加用户信息
    void addUser(User user);
    //删除用户信息
    void deleteUser(User user);
    //修改用户信息
    void updateUser(User user);

    /**
     * 活动管理
     * @return
     */
    //查看活动
    List<Activity> findActivity();
    //审批活动
    void approveActivity(String id,String status);

    /**
     * 查看签到/未签到/请假情况
     * @param theTime
     * @return
     */
    //查询某天已签到记录
    List<Record> findSigned(Date theTime);
    //查询某天未签到记录
    List<Record> findUnsigned(Date theTime);
    //查询某天处于请假的记录
    List<Record> findLeaved(Date theTime);

    //查看请假
    List<Record> findLeave();
    //审批请假
    void approveLeave(String id,String status);


}
