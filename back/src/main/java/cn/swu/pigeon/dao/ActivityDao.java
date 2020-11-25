package cn.swu.pigeon.dao;

import cn.swu.pigeon.entity.Application;
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
}
