package cn.swu.pigeon.service;

import cn.swu.pigeon.dao.ActivityDao;
import cn.swu.pigeon.entity.Activity;
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
        activityDao.submitAct(activity);
    }
}
