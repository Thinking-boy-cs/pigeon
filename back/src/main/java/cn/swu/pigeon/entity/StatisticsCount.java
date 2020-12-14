package cn.swu.pigeon.entity;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class StatisticsCount {
    //统计的栏目名
    private String countName;
    //该栏目的数量
    private int countNumber;
}
