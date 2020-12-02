package cn.swu.pigeon.service;


import cn.swu.pigeon.entity.Application;

import java.util.List;

public interface ApplicationService {
    //提交活动
    void submitApplication(Application application);
    //撤销活动
    void backApplication(int activityId);
    //找到所有活动
    List<Application> findApplication(String id);
}
