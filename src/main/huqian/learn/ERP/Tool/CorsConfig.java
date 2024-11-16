package learn.ERP.Tool;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // 允许所有路径跨域访问，可以根据需要修改为具体的路径
                .allowedOriginPatterns("*") // 允许所有来源跨域访问，可以根据需求修改为指定的来源
                .allowedMethods("GET", "POST", "PUT", "DELETE") // 允许的请求方法
                .allowedHeaders("*") // 允许的请求头
                .allowCredentials(true) // 是否允许发送 Cookie
                .maxAge(3600); // 预检请求的有效期，单位为秒
    }
}
