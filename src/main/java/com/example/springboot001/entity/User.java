package com.example.springboot001.entity;

import lombok.Data;

@Data
public class User {
    private Integer userId;//用户id
    private String userName;//用户名称
    private String password;//用户密码
    private Integer sex;//用户性别 0女 1男
}
