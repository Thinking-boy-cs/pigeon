package cn.swu.pigeon.service;

import cn.swu.pigeon.entity.Company;

import java.util.List;

public interface CompanyService {
    //添加企业字段
    void addCompany(Company company);
    //修改企业信息
    void changeCompany(Company company);
    //删除企业信息
    void deleteCompany(String id);
    //查看企业信息
    List<Company> findCompany();
    //查询某个企业信息
    Company queryCompany(String id);
}
