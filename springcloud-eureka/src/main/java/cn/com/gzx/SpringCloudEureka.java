package cn.com.gzx;

import cn.com.gzx.config.UserTest;
import cn.com.gzx.entity.User;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@EnableEurekaServer
public class SpringCloudEureka {

    public static void main(String[] args) throws Exception {
        // SpringApplication.run(SpringCloudEureka.class, args);
        ConfigurableApplicationContext context = new SpringApplicationBuilder(SpringCloudEureka.class).web(true).run(
                args);
//        User user = context.getBean(User.class);
//        ObjectMapper objectMapper = new ObjectMapper();
//        String json = objectMapper.writeValueAsString(user);
//        System.out.println("user=" + json);
//        UserTest userTest = context.getBean(UserTest.class);
//        System.out.println("userTest is " + userTest);
//        objectMapper = new ObjectMapper();
//        json = objectMapper.writeValueAsString(userTest);
//        System.out.println("userTest=" + json);
    }
}
