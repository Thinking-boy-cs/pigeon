package cn.swu.pigeon.service;

import cn.swu.pigeon.entity.Company;

public interface CompanyService {
    //添加企业字段
    void addCompany(Company company);
    //修改企业信息
    void changeCompany(Company company);
}
