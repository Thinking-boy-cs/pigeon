package cn.swu.pigeon.service;

import cn.swu.pigeon.dao.StatisticsViewDao;
import cn.swu.pigeon.entity.StatisticsCount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ViewDataServiceImpl implements ViewDataService {

    @Autowired
    private StatisticsViewDao statisticsViewDao;


    @Override
    public List<StatisticsCount> viewDeptNumber(String companyId) {
        System.out.println(statisticsViewDao.dept_userNumber(companyId));
        return statisticsViewDao.dept_userNumber(companyId);
    }
}
