package cn.taike.spring.mvc;

import cn.taike.spring.interceptor.InterceptorSample;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 * Created by huayandong on 17/8/28.
 */
@Configuration
@EnableWebMvc       // 开启springmvc支持，没有此句，重写的方法无效；
@ComponentScan("cn.taike.spring.mvc")
public class MyMvcConfig extends WebMvcConfigurerAdapter {    // 继承WebMvcConfigurerAdapter类，重写其方法可以对springMvc的配置；

    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/classes/view/");
        viewResolver.setSuffix(".jsp");
        viewResolver.setViewClass(JstlView.class);
        return viewResolver;
    }

    // 重写继承类的方法，配置静态资源的位置
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/assets/**")   // 指的是对外暴露的访问路径
                .addResourceLocations("classpath:/assets");     // 指的是文件放置的目录
    }

    // 配置拦截器的Bean
    @Bean
    public InterceptorSample interceptorSample() {
        return new InterceptorSample();
    }

    /**
     * 重写addInterceptor方法，注册拦截器
     *
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(interceptorSample());
    }

}
