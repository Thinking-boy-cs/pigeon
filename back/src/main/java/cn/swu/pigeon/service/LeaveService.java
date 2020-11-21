package cn.swu.pigeon.service;

import cn.swu.pigeon.entity.Activity;
import cn.swu.pigeon.entity.Leave;
import cn.swu.pigeon.entity.User;

import java.util.List;

public interface LeaveService {
    void submitLeave(Leave leave);
    void backLeave(Leave leave);
    List<Leave> findLeave(User user);
}
