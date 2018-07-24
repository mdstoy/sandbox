package com.github.mdstoy.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
        try(ConfigurableApplicationContext context = SpringApplication.run(DemoApplication.class, args)) {
			SampleBean bean = context.getBean(SampleBean.class);
			bean.run();
		}
	}
}
