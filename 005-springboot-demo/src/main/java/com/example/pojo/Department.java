package com.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 部门表
 */
@Data
@AllArgsConstructor//有参数构造
@NoArgsConstructor//无参构造
public class Department {
    private Integer Id;
    private String departmentName;
}
