package cn.swu.pigeon.dao;

import cn.swu.pigeon.entity.Company;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CompanyDao {
    //添加企业字段
    void addCompany(Company company);
    //修改企业字段
    void changeCompany(Company company);
}
