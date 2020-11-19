package cn.swu.pigeon.dao;

import cn.swu.pigeon.entity.Activity;
import cn.swu.pigeon.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ActivityDao {
    void submitAct(Activity activity);
    void backAct(Activity activity);
    Activity findAct(User user);
}
