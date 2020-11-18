package cn.swu.pigeon.dao;

import cn.swu.pigeon.entity.Activity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ActivityDao {
    void submitAct(Activity activity);
}
