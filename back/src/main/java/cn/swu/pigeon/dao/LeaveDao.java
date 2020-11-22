package cn.swu.pigeon.dao;

//import cn.swu.pigeon.entity.Activity;
import cn.swu.pigeon.entity.Leave;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface LeaveDao {
    //提交请假
    void submitAct(Leave leave);
    //撤回请假
    void backAct(int leaveId);
    //找到自己的所有请假
    List<Leave> findAct(String userId);
    //销假
    void endLev(int id);

}
