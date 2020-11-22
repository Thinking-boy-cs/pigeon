package cn.swu.pigeon.dao;

import cn.swu.pigeon.entity.Record;
import cn.swu.pigeon.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface RecordDAO {
    //签到
    void record(Record record);
    //返回某个用户的所有签到
    List<Record> find(String userId);
}
