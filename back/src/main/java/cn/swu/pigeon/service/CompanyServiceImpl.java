package cn.swu.pigeon.service;

import cn.swu.pigeon.dao.CompanyDao;
import cn.swu.pigeon.entity.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CompanyServiceImpl implements CompanyService{

    @Autowired
    CompanyDao companyDao;

    @Override
    public void addCompany(Company company) {
        companyDao.addCompany(company);
    }

    @Override
    public void changeCompany(Company company) {
        companyDao.changeCompany(company);
    }

    @Override
    public void deleteCompany(String id) {
        companyDao.deleteCompany(id);
    }

    @Override
    public List<Company> findCompany() {
        return companyDao.findCompany();
    }

    @Override
    public Company queryCompany(String id) {
        return companyDao.queryCompany(id);
    }
}
