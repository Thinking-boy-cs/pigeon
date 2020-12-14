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
import java.util.HashMap;
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
    public Map<String,Object> statisticDeptsUserNumber(@RequestParam String companyId){
        companyId = "123456789012345";
        StatisticsCount sc = new StatisticsCount();
        Map<String,Object> map = new HashMap<>();
        try {
            if(!ObjectUtils.isEmpty(companyId)){
                sc = viewDataService.viewDeptNumber(companyId);
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

}
