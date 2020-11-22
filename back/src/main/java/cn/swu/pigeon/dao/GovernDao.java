package cn.swu.pigeon.dao;

import cn.swu.pigeon.entity.Activity;
import cn.swu.pigeon.entity.Record;
import cn.swu.pigeon.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

@Mapper
public interface GovernDao {
    //找到所有用户
    List<User> findUser();
    //添加用户
    User addUser(User user);
    //删除用户
    void deleteUser(String id);
    //更新用户信息
    void updateUser(String id);
    //找到所有活动
    List<Activity> findActivity();
    //审批活动
    void approveActivity(@Param("id") String id,@Param("status") String status);
    //查询某天已签到记录
    List<Record> findSigned(Date theTime);
    //查询某天未签到记录
    List<Record> findUnsigned(Date theTime);
    //查询某天处于请假的记录
    List<Record> findLeave(Date theTime);
}
