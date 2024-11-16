package learn.ERP.configurationFolder;

import cn.dev33.satoken.interceptor.SaInterceptor;
import cn.dev33.satoken.router.SaRouter;
import cn.dev33.satoken.stp.StpUtil;
import learn.ERP.HRM.mapper.Role_resourceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class SaTokenConfigure implements WebMvcConfigurer {
    @Autowired
    private Role_resourceMapper roleResourceMapper;
    // 注册 Sa-Token 的拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 注册路由拦截器，自定义认证规则 
        registry.addInterceptor(new SaInterceptor(handler -> {

            SaRouter.match("").notMatch("").check(r->StpUtil.checkPermission(""));
            
        })).addPathPatterns("/**");
    }
}
