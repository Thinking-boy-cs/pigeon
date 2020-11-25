package cn.swu.pigeon.service;

import cn.swu.pigeon.dao.ActivityDao;
import cn.swu.pigeon.entity.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class ApplicationServiceImpl implements ApplicationService {

    @Autowired
    private ActivityDao activityDao;

    @Override
    public void submitApplication(Application application) {
        application.setSubmitTime(new Date());
        application.setStatus("待审核");
        activityDao.submitApp(application);
    }

    @Override
    public void backApplication(int activityId) {
        activityDao.backApp(activityId);
    }


    @Override
    public List<Application> findApplication(String id) {
        return activityDao.findApp(id);
    }
}
