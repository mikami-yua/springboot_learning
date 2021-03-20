package com.example.dao;

import com.example.pojo.Department;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * 部门dao
 */

@Repository//@Repository用在持久层的接口上，这个注解是将接口的一个实现类交给spring管理。
public class DepartmentDao {
    //模拟数据库的数据
    private static Map<Integer, Department> departments=null;
    static {
        departments=new HashMap<>();//创建部门表
        departments.put(101,new Department(101,"教学部"));
        departments.put(102,new Department(102,"市场部"));
        departments.put(103,new Department(103,"教研部"));
        departments.put(104,new Department(104,"运营部"));
        departments.put(105,new Department(105,"后勤部"));
    }

    //数据库操作
    //获取数据库信息
    public Collection<Department> getDeDepartments(){
        return departments.values();
    }

    //通过id得到部门
    public Department getDepartmentById(Integer id){
        return departments.get(id);
    }


}
