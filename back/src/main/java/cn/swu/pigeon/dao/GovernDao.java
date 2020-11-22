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
    /**
     * 用户管理
     * @return
     */
    //找到所有用户
    List<User> findUser();
    //添加用户
    User addUser(User user);
    //删除用户
    void deleteUser(String id);
    //更新用户信息
    void updateUser(String id);

    /**
     * 活动管理
     * @return
     */
    //找到所有活动
    List<Activity> findActivity();
    //审批活动
    void approveActivity(@Param("id") String id,@Param("status") String status);

    /**
     * 查看某天的签到/未签到/请假情况
     * @param theTime
     * @return
     */
    //查询某天已签到记录
    List<Record> findSigned(Date theTime);
    //查询某天未签到记录
    List<Record> findUnsigned(Date theTime);
    //查询某天处于请假的记录
    List<Record> findLeaved(Date theTime);

    //找到所有请假
    List<Record> findLeave();
    //审批请假
    void approveLeave(@Param("id") String id,@Param("status") String status);
}
