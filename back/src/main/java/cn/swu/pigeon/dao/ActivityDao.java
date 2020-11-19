package cn.swu.pigeon.dao;

import cn.swu.pigeon.entity.Activity;
import cn.swu.pigeon.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ActivityDao {
    void submitAct(Activity activity);
    void backAct(Activity activity);
    List<Activity> findAct(User user);
}
