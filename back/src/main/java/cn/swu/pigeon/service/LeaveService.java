package cn.swu.pigeon.service;

import cn.swu.pigeon.entity.Activity;
import cn.swu.pigeon.entity.Leave;
import cn.swu.pigeon.entity.User;

import java.util.List;

public interface LeaveService {
    //提交请假
    void submitLeave(Leave leave);
    //撤回请假
    void backLeave(int id);
    //查看自己的请假
    List<Leave> findLeave(String userId);
    //销假
    void endLev(int id);
}
