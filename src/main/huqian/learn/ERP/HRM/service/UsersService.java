package learn.ERP.HRM.service;

import learn.ERP.HRM.Entity.DTO.ResultMsg;
import learn.ERP.HRM.Entity.Users;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author huqian
 * @since 2024-11-12
 */
public interface UsersService extends IService<Users> {
    public ResultMsg verification(Users users);
}
