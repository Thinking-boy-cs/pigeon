package cn.swu.pigeon.service;

import cn.swu.pigeon.dao.InfoCollectDao;
import cn.swu.pigeon.entity.InfoCollect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class InfoCollectServiceImpl implements InfoCollectService{

    @Autowired
    InfoCollectDao infoCollectDao;

    @Override
    public List<InfoCollect> findInfoCollect(Date theTime) {
        return infoCollectDao.findInfoCollect(theTime);
    }
}
