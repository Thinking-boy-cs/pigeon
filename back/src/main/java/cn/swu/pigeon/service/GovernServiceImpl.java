package cn.swu.pigeon.service;

import cn.swu.pigeon.dao.GovernDao;
import cn.swu.pigeon.entity.Application;
import cn.swu.pigeon.entity.Leave;
import cn.swu.pigeon.entity.Record;
import cn.swu.pigeon.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class GovernServiceImpl implements GovernService{

    @Autowired
    GovernDao governDao;


    /**
     * 对用户的管理
     * @return
     */
    @Override
    public List<User> findUsers() {
        return governDao.findUser();
    }

    @Override
    public void addUser(User user) {
        user.setRegisterTime(new Date());
        user.setIcon("/default");
        governDao.addUser(user);
    }

    @Override
    public void deleteUser(User user) {
        governDao.deleteUser(user.getId());
    }

    @Override
    public void updateUser(User user) {
        user.setRegisterTime(new Date());
        governDao.updateUser(user);
    }

    @Override
    public User queryUser(String id) {
        return governDao.queryUser(id);
    }


    /**
     * 对活动的管理
     * @return
     */
    @Override
    public List<Application> findApplication() {
        return governDao.findApplication();
    }

    @Override
    public void approveApplication(String id,String status) {
        governDao.approveApplication(id,status);
    }

    /**
     * 查看签到/未签到/请假情况
     * @param theTime
     * @return
     */
    @Override
    public List<Record> findSigned(String theTime) {
        return governDao.findSigned(theTime);
    }

    @Override
    public List<User> findUnsigned(String theTime) {
        return governDao.findUnsigned(theTime);
    }

    @Override
    public List<Leave> findLeaved(String theTime) {
        return governDao.findLeaved(theTime);
    }

    @Override
    public int leavedCount(String theTime) {
        return governDao.leavedCount(theTime);
    }

    /**
     * 对请假的管理
     * @return
     */
//    @Override
//    public List<Record> findLeave(Date date) {
//        return governDao.findLeave(date);
//    }

    @Override
    public void approveLeave(String id, String status) {
        governDao.approveLeave(id,status);
    }

    /**
     *根据指定日期查询已签到人数
     * @param theTime
     * @return
     */
    @Override
    public int cSigned(String theTime) {
        return governDao.cSigned(theTime);
    }

    /**
     * 根据指定日期查询未签到人数
     * @param theTime
     * @return
     */
    @Override
    public int cUnsigned(String theTime) {
        return governDao.cUnsigned(theTime);
    }
}
