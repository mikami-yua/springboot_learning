package com.example.dao;

import com.example.pojo.Department;
import com.example.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * 员工
 */
@Repository
public class EmployeeDao {
    //模拟数据库
    private static Map<Integer, Employee> employees=null;
    //员工有所属的部门
    @Autowired
    private DepartmentDao departmentDao;
    static {
        employees=new HashMap<>();
        employees.put(101,new Employee(1001,"AA","a123456@qq.com",1,new Department(101,"教学部")));
        employees.put(102,new Employee(1002,"BB","b123456@qq.com",1,new Department(102,"市场部")));
        employees.put(103,new Employee(1003,"CC","c123456@qq.com",0,new Department(103,"教研部")));
        employees.put(104,new Employee(1004,"DD","d123456@qq.com",1,new Department(104,"运营部")));
        employees.put(105,new Employee(1005,"EE","e123456@qq.com",0,new Department(105,"后勤部")));
    }

    //主键自增
    private static Integer initId=1006;
    //增加员工
    public void addEmployee(Employee employee){
        if (employee.getId()==null){
            employee.setId(initId++);
        }

        employee.setDepartment(departmentDao.getDepartmentById(employee.getDepartment().getId()));
        employees.put(employee.getId(),employee);
    }

    //查询全部员工
    public Collection<Employee> getAllEmployee(){
        return employees.values();
    }

    //通过id查询员工
    public Employee getEmployeeById(Integer id){
        return employees.get(id);
    }

    //删除员工
    public void deleteEmployeeById(Integer id){
        employees.remove(id);
    }

}
