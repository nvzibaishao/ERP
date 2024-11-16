package learn.ERP.HRM.controller;


import learn.ERP.HRM.Entity.Employee;
import learn.ERP.HRM.Entity.DTO.ResultMsg;
import learn.ERP.HRM.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author huqian
 * @since 2024-11-10
 */
@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/addUser")
    public ResultMsg addUser(@RequestBody Employee employee){
       return employeeService.insertEmployee(employee);
    }





}

