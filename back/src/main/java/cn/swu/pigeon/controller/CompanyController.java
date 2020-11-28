package cn.swu.pigeon.controller;

import cn.swu.pigeon.entity.Company;
import cn.swu.pigeon.service.CompanyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@CrossOrigin //允许跨域
@RequestMapping("company")
@Slf4j
public class CompanyController {

    @Autowired
    CompanyService companyService;

    /**
     * 添加company表
     * @param company
     * @return
     */
    @RequestMapping("addCompany")
    public Map<String,Object> addCompany(@RequestBody Company company){
        Map<String, Object> map =  new HashMap<>();
        try {
            companyService.addCompany(company);
            map.put("status",0);
            map.put("msg","插入成功!");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("status",1);
            map.put("msg",e.getMessage());
        }
        return map;
    }

    /**
     * 修改企业信息
     * @param company
     * @return
     */
    @RequestMapping("changeCompany")
    public Map<String,Object> changeCompany(@RequestBody Company company){
        Map<String, Object> map =  new HashMap<>();
        try {
            companyService.changeCompany(company);
            map.put("status",0);
            map.put("msg","修改成功!");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("status",1);
            map.put("msg",e.getMessage());
        }
        return map;
    }

    /**
     * 找到企业信息
     * @return
     */
    @RequestMapping("findCompany")
    public Map<String,Object> findCompany(){
        Map<String, Object> map =  new HashMap<>();
        try {
            List<Company> thisCompany = companyService.findCompany();
            map.put("status",0);
            map.put("msg","修改成功!");
            map.put("data",thisCompany);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("status",1);
            map.put("msg",e.getMessage());
            map.put("data",null);
        }
        return map;
    }

    /**
     * 查询某个企业信息
     * @param id
     * @return
     */
    @RequestMapping("queryCompany")
    public Map<String,Object> queryCompany(String id){
        Map<String, Object> map =  new HashMap<>();
        try {
            Company thisCompany = companyService.queryCompany(id);
            map.put("status",0);
            map.put("msg","修改成功!");
            map.put("data",thisCompany);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("status",1);
            map.put("msg",e.getMessage());
            map.put("data",null);
        }
        return map;
    }

    /**
     * 删除企业信息
     * @param id
     * @return
     */
    @RequestMapping("deleteCompany")
    public Map<String,Object> deleteCompany(String id){
        Map<String, Object> map =  new HashMap<>();
        try {
            companyService.deleteCompany(id);
            map.put("status",0);
            map.put("msg","修改成功!");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("status",1);
            map.put("msg",e.getMessage());
        }
        return map;
    }


}
