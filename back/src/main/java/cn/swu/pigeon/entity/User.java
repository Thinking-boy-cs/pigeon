package cn.swu.pigeon.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@Accessors(chain = true)
public class User {
    private String id;
    private String username;
    private String dept;
    private String password;
    private String sex;
    private String status;
    private Date registerTime;
    private String icon;


}