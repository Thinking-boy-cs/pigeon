package cn.swu.pigeon.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.swu.pigeon.dao.ActivityDao;
import cn.swu.pigeon.entity.Activity;
import cn.swu.pigeon.entity.Record;
import cn.swu.pigeon.entity.User;

@Service
public class ActivityServiceImpl implements ActivityService {
  @Autowired
  private ActivityDao activityDao;

  @Override
  public Activity getById(String id) {
    return activityDao.getById(id);
  }
  @Override
  public List<Activity> getByUserId(String id){
    return activityDao.getByUserId(id);
  }
  @Override
  public List<Activity> getByApproverId(String id){
    return activityDao.getByApproverId(id);
  }
  @Override
  public List<User> getRelatedUsers(String id){
    return activityDao.getRelatedUsers(id);
  }
  @Override
  public List<Record> getRecordsById(String id){
    return activityDao.getRecordsById(id);
  }
  @Override
  public void insertActivity(Activity activity) {
    activityDao.insertActivity(activity);
  }
  @Override
  public void participate(String id, String activityId, String userId) {
    activityDao.participate(id, activityId, userId);
  }
  @Override
  public Integer getStatus(String activityId, String userId) {
    return activityDao.getStatus(activityId, userId);
  }
  @Override
  public void sign(String activityId, String userId) {
    activityDao.sign(activityId, userId);
  }
}