package com.example.controller;

import com.example.dao.EmployeeDao;
import com.example.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

/**
 * 员工管理
 * controller调用service层，本项目没有数据库，直接调用dao层
 */
@Controller
public class EmployeeController {

    @Autowired
    EmployeeDao employeeDao;

    /**
     * 展示所有员工
     * @param model 返回前端结果
     * @return 返回结果展示页面
     */
    @RequestMapping("/emps")
    public String list(Model model){
        Collection<Employee> employees=employeeDao.getAllEmployee();
        model.addAttribute("emps",employees);
        return "emp/list";
    }
}
