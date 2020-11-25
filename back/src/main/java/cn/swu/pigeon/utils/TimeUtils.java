package cn.swu.pigeon.utils;

import lombok.Data;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;

@Data
@Component
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
    public static Long getDistinateTimeDelta(Date date) {
        return date.getTime() - new Date().getTime();
    }
    public static Date convertToDate(String dateStr, String format) {
        DateFormat dateFormat = new SimpleDateFormat(format);//日期格式
        Date date = null;
        try {
            date = dateFormat.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
    public static String convertToString(Date date, String format) {
        SimpleDateFormat sformat = new SimpleDateFormat(format);//日期格式
        String dateStr = sformat.format(date);

        return dateStr;
    }
}


