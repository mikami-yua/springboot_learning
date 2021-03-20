package com.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 员工表
 */
@Data
@NoArgsConstructor//为了日期自动生成，不能使用有参构造
public class Employee {
    private Integer id;
    private String lastName;
    private String email;
    private Integer gender;//0 female

    private Department department;
    private Date birth;

    public Employee(Integer id, String lastName, String email, Integer gender, Department department) {
        this.id = id;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.department = department;
        this.birth = new Date();//自动生成日期
    }
}
