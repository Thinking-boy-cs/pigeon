package cn.swu.pigeon.service;

import cn.swu.pigeon.dao.ActivityDao;
import cn.swu.pigeon.entity.Activity;
import cn.swu.pigeon.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
@Transactional
public class ActivityServiceImpl implements ActivityService{

    @Autowired
    private ActivityDao activityDao;

    @Override
    public void submitActivity(Activity activity) {
        activity.setSubmitTime(new Date());
        activity.setStatus("待审核");
        activityDao.submitAct(activity);
    }

    @Override
    public void backActivity(Activity activity) {
        activityDao.backAct(activity);
    }

    @Override
    public Activity findActivity(User user) {
        return activityDao.findAct(user);
    }
}
