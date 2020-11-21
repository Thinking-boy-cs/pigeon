package cn.swu.pigeon.service;

import cn.swu.pigeon.entity.Activity;
import cn.swu.pigeon.entity.Leave;
import cn.swu.pigeon.entity.User;

import java.util.List;

public interface LeaveService {
    void submitLeave(Leave leave);
    void backLeave(int id);
    List<Leave> findLeave(String userId);
}
