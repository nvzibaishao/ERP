package learn.ERP.HRM.service;

import learn.ERP.HRM.Entity.DTO.ResultMsg;
import com.baomidou.mybatisplus.extension.service.IService;
import learn.ERP.HRM.Entity.Employee;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author huqian
 * @since 2024-11-10
 */
public interface EmployeeService extends IService<Employee> {
    public ResultMsg insertEmployee(Employee employee);
}
