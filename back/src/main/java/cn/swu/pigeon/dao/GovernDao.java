package cn.swu.pigeon.dao;

import cn.swu.pigeon.entity.Application;
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
    List<Application> findApplication();
    //审批活动
    void approveApplication(@Param("id") String id,@Param("status") String status);

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

    /**
     * 请假管理
     * @return
     */
    //找到所有请假
    List<Record> findLeave(Date date);
    //审批请假
    void approveLeave(@Param("id") String id,@Param("status") String status);

    /**
     * 统计已签到的人数和未签到的人数，根据当前用户注册表而言
     * @return
     */
    int cSigned();
    int cUnsigned();
}
