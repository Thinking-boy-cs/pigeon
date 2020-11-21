package cn.swu.pigeon.dao;

import cn.swu.pigeon.entity.Activity;
import cn.swu.pigeon.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ActivityDao {
    //提交活动
    void submitAct(Activity activity);
    //撤销活动
    void backAct(int activityId);
    //找到所有活动
    List<Activity> findAct(String userId);
}
