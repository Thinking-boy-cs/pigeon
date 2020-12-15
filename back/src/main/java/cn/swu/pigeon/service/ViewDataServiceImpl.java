package cn.swu.pigeon.service;

import cn.swu.pigeon.dao.StatisticsViewDao;
import cn.swu.pigeon.entity.StatisticsCount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class ViewDataServiceImpl implements ViewDataService {

    @Autowired
    private StatisticsViewDao statisticsViewDao;

    //统计各个部门的人数
    @Override
    public List<StatisticsCount> viewDeptNumber(String companyId) {
        System.out.println(statisticsViewDao.dept_userNumber(companyId));
        return statisticsViewDao.dept_userNumber(companyId);
    }

    //统计公司男女人数情
    @Override
    public List<StatisticsCount> viewSexNumber(String companyId) {
        System.out.println(statisticsViewDao.sex_userNumber(companyId));
        return statisticsViewDao.sex_userNumber(companyId);
    }

    //统计员工的家乡
    @Override
    public List<StatisticsCount> viewHometownNumber(String companyId) {
        return statisticsViewDao.hometown_userNumber(companyId);
    }

    //统计员工的薪资情况
    @Override
    public List<StatisticsCount> viewSalaryNumber(String companyId) {
        return statisticsViewDao.salary_userNumber(companyId);
    }

    //统计员工在离职情况
    @Override
    public List<StatisticsCount> viewStatusNumber(String companyId, String time){
        return statisticsViewDao.status_userNumber(companyId,time);
    }
}
