package learn.ERP.HRM.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import learn.ERP.HRM.Entity.Employee;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author huqian
 * @since 2024-11-10
 */
@Mapper
public interface EmployeeMapper extends BaseMapper<Employee> {

}
