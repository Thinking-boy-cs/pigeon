package cn.swu.pigeon.service;

import cn.swu.pigeon.dao.LeaveDao;
import cn.swu.pigeon.entity.Leave;
import cn.swu.pigeon.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 *服务层实现类
 */
@Service
@Transactional
@Slf4j
public class LeaveServiceImpl implements LeaveService{

    @Resource
    @Autowired
    private LeaveDao leaveDao;

    @Override
    public void submitLeave(Leave leave) {
        leave.setSubmitTime(new Date());
//        leave.setSubmitTime()
//        leave.setStatus()
        leave.setStatus("待审核");
        System.out.println(leave.getSubmitTime());
        System.out.println(leave.getStatus());
        log.info("[{}]",leave.toString());
        /**
         * 注意需要获取当前用户的id
         */
        leaveDao.submitAct(leave);

    }

    @Override
    public void backLeave(Leave leave) {
        leaveDao.backAct(leave);

    }

    @Override
    public List<Leave> findLeave(User user) {
        return leaveDao.findAct(user.getId());
    }
}
