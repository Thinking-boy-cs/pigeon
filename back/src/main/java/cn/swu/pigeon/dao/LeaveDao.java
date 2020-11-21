package cn.swu.pigeon.dao;

//import cn.swu.pigeon.entity.Activity;
import cn.swu.pigeon.entity.Leave;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface LeaveDao {
    void submitAct(Leave leave);
    void backAct(int leaveId);
    List<Leave> findAct(String userId);
    //销假
    void endLev(int id);

}
