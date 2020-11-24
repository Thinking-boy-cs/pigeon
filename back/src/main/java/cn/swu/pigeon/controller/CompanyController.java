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
}
