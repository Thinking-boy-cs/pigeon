package cn.swu.pigeon.service;

import cn.swu.pigeon.dao.StatisticsViewDao;
import cn.swu.pigeon.entity.StatisticsCount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ViewDataServiceImpl implements ViewDataService {

    @Autowired
    private StatisticsViewDao statisticsViewDao;


    @Override
    public StatisticsCount viewDeptNumber(String companyId) {
        return statisticsViewDao.dept_userNumber(companyId);
    }
}
