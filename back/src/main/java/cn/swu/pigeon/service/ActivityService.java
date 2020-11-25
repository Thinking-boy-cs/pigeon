package cn.swu.pigeon.service;

import java.util.List;

import org.springframework.stereotype.Service;

import cn.swu.pigeon.entity.Activity;
import cn.swu.pigeon.entity.Record;
import cn.swu.pigeon.entity.User;


public interface ActivityService {
    public Activity getById(String id);
    public List<Activity> getByUserId(String id);
    public List<Activity> getByApproverId(String id);
    public List<User> getRelatedUsers(String id);
    public List<Record> getRecordsById(String id);
    public void insertActivity(Activity activity);
    public void participate(String id, String activityId, String userId);
    public Integer getStatus(String activityId, String userId);
    public void sign(String activityId, String userId);
}