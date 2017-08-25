package cn.taike.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by huayandong on 17/8/25.
 */
@Configuration
@ComponentScan("cn.taike.bean")
public class Configurations {

    @Bean
    public FunctionService getFunctionService() {
        return new FunctionService();
    }
}
