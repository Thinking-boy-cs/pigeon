package cn.swu.pigeon.dao;

import cn.swu.pigeon.entity.Company;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CompanyDao {
    //添加企业字段
    void addCompany(Company company);
    //修改企业字段
    void changeCompany(Company company);
    //删除企业信息
    void deleteCompany(String id);
    //查看企业信息
    List<Company> findCompany();
    //查询某个企业信息
    Company queryCompany(String id);
}
