package cn.swu.pigeon.dao;

import cn.swu.pigeon.entity.Record;
import cn.swu.pigeon.entity.User;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface RecordDAO {
    void record(Record record);
}
