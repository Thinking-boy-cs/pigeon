package cn.swu.pigeon.controller;

import cn.swu.pigeon.dao.StatisticsViewDao;
import cn.swu.pigeon.entity.StatisticsCount;
import cn.swu.pigeon.entity.User;
import cn.swu.pigeon.service.ViewDataService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 统计操作
 */
@RestController
@CrossOrigin // 允许跨域
@RequestMapping("view")
@Slf4j
public class StatisticsViewController {

    @Autowired
    ViewDataService viewDataService;

    /**
     * 1.签到统计
     * 1.1一段时间曲线统计图（已签到/未签到/请假）（光滑曲线）
     *
     */

    /**
     * 2.活动统计
     *
     */

    /**
     * 3.员工统计
     * 3.1性别（饼图）
     * 3.2薪资待遇（分段展示）
     *
     */

    //各个部门员工人数统计
    @RequestMapping("dept_userNumber")
    public Map<String,Object> statisticsDeptUserNumber(String companyId){
        //测试
        //String companyId = "123456789012345";

        Map<String,Object> map = new HashMap<>();
        try {
            if(!ObjectUtils.isEmpty(companyId)){
                List<StatisticsCount> sc = viewDataService.viewDeptNumber(companyId);
                //System.out.println(sc.get(0).getCountName());
                //System.out.println(sc.get(0).getCountNumber());
                map.put("status",0);
                map.put("msg","查看成功");
                map.put("data",sc);
            } else {
                map.put("status",1);
                map.put("msg","查看失败");
            }
            return map;
        } catch (Exception e){
            e.printStackTrace();
            map.put("status",1);
            map.put("msg","查看失败");
            return map;
        }
    }

    //公司男女情况人数统计
    @RequestMapping("sex_userNumber")
    public Map<String,Object> statisticsSexUserNumber(String companyId){
        //测试
        //String companyId = "123456789012345";

        Map<String,Object> map = new HashMap<>();
        try {
            if(!ObjectUtils.isEmpty(companyId)){
                List<StatisticsCount> sx = viewDataService.viewSexNumber(companyId);
                map.put("status",0);
                map.put("msg","查看成功");
                map.put("data",sx);
            } else {
                map.put("status",1);
                map.put("msg","查看失败");
            }
            return map;
        } catch (Exception e){
            e.printStackTrace();
            map.put("status",1);
            map.put("msg","查看失败");
            return map;
        }
    }

    //公司员工家乡情况人数统计
    @RequestMapping("hometown_userNumber")
    public Map<String,Object> statisticsHometownUserNumber(String companyId){
        //测试
        //String companyId = "123456789012345";

        Map<String,Object> map = new HashMap<>();
        try {
            if(!ObjectUtils.isEmpty(companyId)){
                List<StatisticsCount> sh = viewDataService.viewHometownNumber(companyId);
                map.put("status",0);
                map.put("msg","查看成功");
                map.put("data",sh);
            } else {
                map.put("status",1);
                map.put("msg","查看失败");
            }
            return map;
        } catch (Exception e){
            e.printStackTrace();
            map.put("status",1);
            map.put("msg","查看失败");
            return map;
        }
    }

    //员工薪资情况人数统计
    @RequestMapping("salary_userNumber")
    public Map<String,Object> statisticsSalaryUserNumber(String companyId){
        //测试
        companyId = "123456789012345";

        Map<String,Object> map = new HashMap<>();
        try {
            if(!ObjectUtils.isEmpty(companyId)){
                List<StatisticsCount> sl = viewDataService.viewSalaryNumber(companyId);
                map.put("status",0);
                map.put("msg","查看成功");
                map.put("data",sl);
            } else {
                map.put("status",1);
                map.put("msg","查看失败");
            }
            return map;
        } catch (Exception e){
            e.printStackTrace();
            map.put("status",1);
            map.put("msg","查看失败");
            return map;
        }
    }

    //员工在离职情况统计
    @RequestMapping("letOperation_userNumber")
    public Map<String,Object> statisticsLetUserNumber(){
        //测试
        String companyId = "123456789012345";

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //String time = simpleDateFormat.format(tDate);
        String time = "2020-12-15";
        Map<String,Object> map = new HashMap<>();
        try {
            if(!ObjectUtils.isEmpty(companyId)){
                List<StatisticsCount> sp = viewDataService.viewStatusNumber(companyId,time);
                map.put("status",0);
                map.put("msg","查看成功");
                map.put("data",sp);
            } else {
                map.put("status",1);
                map.put("msg","查看失败");
            }
            return map;
        } catch (Exception e){
            e.printStackTrace();
            map.put("status",1);
            map.put("msg","查看失败");
            return map;
        }
    }

}
