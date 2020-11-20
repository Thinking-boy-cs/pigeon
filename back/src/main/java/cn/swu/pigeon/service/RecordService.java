package cn.swu.pigeon.service;

import cn.swu.pigeon.entity.Record;
import cn.swu.pigeon.entity.User;

import java.util.List;

public interface RecordService {
    //签到响应
    void isSign(Record record);
    //签到查看
    List<Record> findRec(User user);
}
