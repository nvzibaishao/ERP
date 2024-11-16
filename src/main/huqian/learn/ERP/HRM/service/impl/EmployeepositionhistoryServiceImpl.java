package learn.ERP.HRM.service.impl;

import learn.ERP.HRM.Entity.DTO.ResultMsg;
import learn.ERP.HRM.Entity.Employee;
import learn.ERP.HRM.Entity.Employeepositionhistory;
import learn.ERP.HRM.mapper.EmployeeMapper;
import learn.ERP.HRM.mapper.EmployeepositionhistoryMapper;
import learn.ERP.HRM.service.EmployeepositionhistoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * <p>
 * 员工岗位变更历史表 服务实现类
 * </p>
 *
 * @author huqian
 * @since 2024-11-11
 */
@Service
public class EmployeepositionhistoryServiceImpl extends ServiceImpl<EmployeepositionhistoryMapper, Employeepositionhistory> implements EmployeepositionhistoryService {

    @Autowired
    private EmployeeMapper employeeMapper;
    @Autowired
    private EmployeepositionhistoryMapper employeepositionhistoryMapper;
    public ResultMsg JobChanges(Employee employee){
        ResultMsg resultMsg = new ResultMsg("插入成功", null, 200);
        try {
            employee.setLastModifiedDate(LocalDateTime.now());
            employeeMapper.updateById(employee);
            //employeepositionhistoryMapper.insert();
        }catch (Exception ex){
            resultMsg.info="插入失败";
            resultMsg.Data= ExceptionUtils.getStackTrace(ex);
            resultMsg.status=500;
        }
        return  resultMsg;
    }
}
