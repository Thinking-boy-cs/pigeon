package cn.swu.pigeon.utils;

import lombok.Data;

import java.util.Date;

@Data
public class TimeUtils {
    private Date startTime;
    private Date endTime;

    public static TimeUtils timeInvert(Date date){
        TimeUtils timeUtils = new TimeUtils();
        Date start = date;
        Date end = date;
        start.setHours(0);
        end.setHours(23);
        start.setMinutes(0);
        end.setMinutes(59);
        start.setSeconds(0);
        end.setSeconds(59);
        timeUtils.setStartTime(start);
        timeUtils.setEndTime(end);
        return timeUtils;
    }
}


