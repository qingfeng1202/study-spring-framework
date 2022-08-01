package com.qingfeng.test;

import com.qingfeng.pojo.MyTestBean;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyApplicationContextTest {

	@Test
	public void test(){
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

		MyTestBean myTestBean = context.getBean("myTestBean", MyTestBean.class);

		System.out.println(myTestBean.getMyTestStr());
	}

}
