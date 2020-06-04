package com.xuecheng.test.freemarker.model;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author wtzhou
 * @date 2020/6/2 4:51 下午
 **/
@Data
public class Student {

    private String name;
    private int age;
    private Date birthday;
    private Float money;
    private List<Student> friends;
    private Student bestFriend;
}
