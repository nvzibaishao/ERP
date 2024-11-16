package learn.ERP.HRM.service.impl;

import learn.ERP.HRM.Entity.DTO.ResultMsg;
import learn.ERP.HRM.Entity.Employee;
import learn.ERP.HRM.mapper.EmployeeMapper;
import learn.ERP.HRM.service.EmployeeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author huqian
 * @since 2024-11-10
 */
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService {
@Autowired
public EmployeeMapper employeeMapper;

    public ResultMsg insertEmployee(Employee employee){
        ResultMsg resultMsg = new ResultMsg("插入成功", null, 200);
        try {
            employeeMapper.insert(employee);
        }catch (Exception ex){
            resultMsg.info="插入失败";
            resultMsg.Data= ExceptionUtils.getStackTrace(ex);
            resultMsg.status=500;
        }
        return  resultMsg;
    }
}
