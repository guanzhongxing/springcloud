package cn.com.gzx.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.com.gzx.utils.ApplicationContextHelper;

@RestController
@RequestMapping("/apply")
public class ApplyController {

    private Logger Logger = LoggerFactory.getLogger(ApplyController.class);

    @GetMapping("/getAppName")
    public String getApplicationName() {
        Logger.info("getApplicationName start");
        String appName = ApplicationContextHelper.applicationContext
                .getEnvironment().getProperty("spring.application.name");
        System.out.println("appName:" + appName);
        Logger.info("getApplicationName end");
        return appName;
    }

    @RequestMapping(value = "/getName", method = RequestMethod.GET)
    public String getName() {
        return "welcome my world";
    }

}
