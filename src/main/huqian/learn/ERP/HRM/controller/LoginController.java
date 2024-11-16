package learn.ERP.HRM.controller;

import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import learn.ERP.HRM.Entity.DTO.ResultMsg;
import learn.ERP.HRM.Entity.Users;
import learn.ERP.HRM.mapper.UsersMapper;
import learn.ERP.HRM.service.UsersService;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Login")
public class LoginController {
    @Autowired
    public UsersService usersService;
    @PostMapping("/Verification")
    public ResultMsg verification(@RequestBody Users users){
       return usersService.verification(users);

    }
}
