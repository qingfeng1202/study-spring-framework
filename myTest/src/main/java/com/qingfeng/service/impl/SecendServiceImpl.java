package com.qingfeng.service.impl;

import com.qingfeng.service.FirstService;
import com.qingfeng.service.SecendService;

public class SecendServiceImpl implements SecendService {

	private String name;

	private FirstService firstService;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public FirstService getFirstService() {
		return firstService;
	}

	public void setFirstService(FirstService firstService) {
		this.firstService = firstService;
	}

	@Override
	public void doAction(String from) {
		System.out.println(String.format("%s to %s", from, name));
	}

	@Override
	public void action() {
		firstService.doAction(name);
	}
}
