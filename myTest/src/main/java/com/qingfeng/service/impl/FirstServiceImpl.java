package com.qingfeng.service.impl;

import com.qingfeng.service.FirstService;
import com.qingfeng.service.SecendService;


public class FirstServiceImpl implements FirstService {

	private String name;

	private SecendService secendService;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public SecendService getSecendService() {
		return secendService;
	}

	public void setSecendService(SecendService secendService) {
		this.secendService = secendService;
	}

	@Override
	public void doAction(String from) {
		System.out.println(String.format("%s to %s", from, name));
	}

	@Override
	public void action() {
		secendService.doAction(name);
	}

}
