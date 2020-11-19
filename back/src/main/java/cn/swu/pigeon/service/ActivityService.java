package cn.swu.pigeon.service;


import cn.swu.pigeon.entity.Activity;
import cn.swu.pigeon.entity.User;

public interface ActivityService {
    void submitActivity(Activity activity);
    void backActivity(Activity activity);
    Activity findActivity(User user);
}
