package cn.swu.pigeon.service;

import cn.swu.pigeon.dao.RecordDAO;
import cn.swu.pigeon.entity.Record;
import cn.swu.pigeon.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;


@Service
@Transactional
public class RecordServiceImpl implements RecordService{

    @Autowired
    RecordDAO recordDAO;

    @Override
    public void isSign(Record record) {
        record.setSignTime(new Date());
        recordDAO.record(record);

    }
}
