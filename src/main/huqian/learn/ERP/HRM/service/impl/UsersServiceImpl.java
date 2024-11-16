package learn.ERP.HRM.service.impl;

import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import learn.ERP.HRM.Entity.DTO.ResultMsg;
import learn.ERP.HRM.Entity.Users;
import learn.ERP.HRM.mapper.UsersMapper;
import learn.ERP.HRM.service.UsersService;
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
 * @since 2024-11-12
 */
@Service
public class UsersServiceImpl extends ServiceImpl<UsersMapper, Users> implements UsersService {
    @Autowired
    private UsersMapper usersMapper;
    public ResultMsg verification(Users users){
        ResultMsg resultMsg = new ResultMsg("","",200);
        try {
            QueryWrapper<Users> queryWrapper = new QueryWrapper<Users>();
            queryWrapper.eq("password",users.getPassword()).eq("username",users.getUsername());
            Users usersbyselect = usersMapper.selectOne(queryWrapper);
            if(usersbyselect==null){
                resultMsg.setInfo("账号或密码错误");
                resultMsg.setStatus(500);
                return  resultMsg;
            }else {
                StpUtil.login(usersbyselect.getUser_id());
                String token = StpUtil.getTokenValue();
                resultMsg.setData(token);
                return resultMsg;
            }
        }catch (Exception ex){
            resultMsg.setData(ExceptionUtils.getStackTrace(ex));
        }
        return resultMsg;
    }
}
