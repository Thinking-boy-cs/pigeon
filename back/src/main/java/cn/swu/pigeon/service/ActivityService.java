package cn.swu.pigeon.service;


import cn.swu.pigeon.entity.Activity;
import cn.swu.pigeon.entity.User;

import java.util.List;

public interface ActivityService {
    void submitActivity(Activity activity);
    void backActivity(Activity activity);
    List<Activity> findActivity(User user);
}
