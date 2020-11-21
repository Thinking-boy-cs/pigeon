package cn.swu.pigeon.service;


import cn.swu.pigeon.entity.Activity;
import cn.swu.pigeon.entity.User;

import java.util.List;

public interface ActivityService {
    //提交活动
    void submitActivity(Activity activity);
    //撤销活动
    void backActivity(int activityId);
    //找到所有活动
    List<Activity> findActivity(String id);
}
