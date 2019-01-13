package cn.com.gzx.config;

import cn.com.gzx.entity.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@SpringBootConfiguration
public class ConfigTestClass {

    /*@Value("value=${test.name}")
    private String testName;

    @Bean
    public User initUser() {
        System.out.println("test name is " + testName);
        return new User();
    }*/

}
