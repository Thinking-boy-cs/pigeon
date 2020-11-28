package cn.swu.pigeon.dao;

import cn.swu.pigeon.entity.Activity;
import cn.swu.pigeon.entity.Application;
import cn.swu.pigeon.entity.Record;
import cn.swu.pigeon.entity.User;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ActivityDao {
    //提交活动
    void submitApp(Application application);
    //撤销活动
    void backApp(int activityId);
    //找到所有活动
    List<Application> findApp(String userId);
    Activity getById(String id);
    List<Activity> getByUserId(String id);
    List<Activity> getByApproverId(String id);
    List<User> getRelatedUsers(String id);
    List<Record> getRecordsById(String id);
    void insertActivity(Activity activity);
    void participate(String id, String activityId, String userId);
    Integer getStatus(String activityId, String userId);
	void sign(String activityId, String userId);
    
}
