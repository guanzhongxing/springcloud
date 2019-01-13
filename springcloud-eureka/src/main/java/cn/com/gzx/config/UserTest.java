package cn.com.gzx.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@ConfigurationProperties(prefix = "userTest")
@Component
public class UserTest {

    private String name;

    private String sex;

    private Map mapTest;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Map getMapTest() {
        return mapTest;
    }

    public void setMapTest(Map mapTest) {
        this.mapTest = mapTest;
    }

}
