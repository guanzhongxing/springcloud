package cn.com.gzx;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SpringCloudEureka {

	public static void main(String[] args) {
		// SpringApplication.run(SpringCloudEureka.class, args);
		new SpringApplicationBuilder(SpringCloudEureka.class).web(true).run(
				args);
	}
}
