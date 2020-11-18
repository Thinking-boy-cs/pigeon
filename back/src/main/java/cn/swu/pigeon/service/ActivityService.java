package cn.swu.pigeon.service;


import cn.swu.pigeon.entity.Activity;

public interface ActivityService {
    void submitActivity(Activity activity);
    void backActivity(Activity activity);
}
