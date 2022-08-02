package com.qingfeng.test;

import com.qingfeng.service.FirstService;
import com.qingfeng.service.SecendService;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyApplicationContextTest {

	@Test
	public void test(){
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

		FirstService firstService = context.getBean("firstService", FirstService.class);

		SecendService secendService = context.getBean("secendService", SecendService.class);

		firstService.action();

		secendService.action();
	}

}
