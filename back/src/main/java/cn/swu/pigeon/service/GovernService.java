package cn.swu.pigeon.service;

import cn.swu.pigeon.entity.Application;
import cn.swu.pigeon.entity.Leave;
import cn.swu.pigeon.entity.Record;
import cn.swu.pigeon.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface GovernService {
    /**
     * 用户管理
     * @return
     */
    //查看用户信息
    List<User> findUsersByCompanyId(String companyId);
    List<User> findUsersByDept(String department);

    //添加用户信息
    void addUser(User user);
    //删除用户信息
    void deleteUser(User user);
    //修改用户信息
    void updateUser(User user);
    //查询特定用户信息
    User queryUser(String id);

    /**
     * 活动管理
     * @return
     */
    //查看活动
    List<Application> findApplication(String companyId);
    //审批活动
    void approveApplication(String id,String status);

    /**
     * 查看签到/未签到/请假情况
     * @param theTime
     * @return
     */
    //查询某天已签到记录
    List<Record> findSigned(@Param("companyId") String companyId, @Param("theTime") String theTime);
    //查询某天未签到记录
    List<User> findUnsigned(@Param("companyId") String companyId, @Param("theTime") String theTime);
    //查询某天处于请假的记录
    List<Leave> findLeaved(@Param("companyId") String companyId, @Param("theTime") String theTime);
//    统计某天请假人数
    int leavedCount(String theTime);
    //签到未签到都查询
    List<Map> queryAll(@Param("companyId") String companyId, @Param("theTime") String theTime);


    //审批请假
    void approveLeave(String id,String status);

    /**
     * 统计已签到的人数和未签到的人数，根据当前用户注册表而言
     * @return
     */
    int cSigned(String theTime);
    int cUnsigned(String theTime);

    void letStatusOn(String id);
    void letStatusOff(String id);
}
