package com.jyp.studydemo.cors;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/**
 * @author ：jiyuepeng
 * @date ：Created in 2019/9/7 18:40
 * @description：跨域处理器
 */

@Slf4j
@Order(1000)
@Configuration
@Conditional(CorsFilterCondition.class)
@WebFilter(urlPatterns = { "/" }, filterName = "corsFilters")
public class CorsFilters implements Filter {
    @Override
    public void destroy() {
    }
    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        log.debug("请求进来了");
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse rep = (HttpServletResponse) response;

        String currentOrigin = req.getHeader("Origin");
        //设置允许跨域的配置
        // 这里填写允许进行跨域的主机ip（正式上线时可以动态配置具体允许的域名和IP）
        // Access-Control-Allow-Origin  "*" 与 Access-Control-Allow-Credentials "true"这两个配置是互斥
        rep.setHeader("Access-Control-Allow-Credentials","true");
        rep.setHeader("Access-Control-Allow-Origin", currentOrigin);
//        rep.setHeader("Access-Control-Allow-Origin", "baidu.com");
        // 允许的访问方法
        rep.setHeader("Access-Control-Allow-Methods","POST, GET, PUT, OPTIONS, DELETE, PATCH");
        // Access-Control-Max-Age 用于 CORS 相关配置的缓存
        rep.setHeader("Access-Control-Max-Age", "3600");
        rep.setHeader("Access-Control-Allow-Headers","token,Origin, X-Requested-With, Content-Type, Accept,Content-Disposition");
        String options = "OPTIONS";
        log.debug("请求方式："+req.getMethod());
        if((options).equals(req.getMethod())){
            ((HttpServletResponse) response).setStatus(200);
            log.debug("option is ok");
            return ;
        }
        chain.doFilter(request, rep);
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {

    }

}