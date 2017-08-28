package cn.taike.spring.mvc;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * Created by huayandong on 17/8/28.
 */
// 实现WebApplicationInitializer接口，实现了替代web.xml的位置
public class WebInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext webContext = new AnnotationConfigWebApplicationContext();
        webContext.register(MyMvcConfig.class);
        webContext.setServletContext(servletContext);

        // 注册springMVC的DispatcherServlet
        ServletRegistration.Dynamic servlet = servletContext.addServlet("dispatcher", new DispatcherServlet(webContext));
        servlet.addMapping("/");
        servlet.setLoadOnStartup(1);

    }
}
