package com.raq.spring.schduler;

public class PojoTask {
	
	public void execute(){
		System.out.println("running schduled task via Spring POJO");
	}
	
	public void executeWithCron(){
		System.out.println("running schduled executeWithCron via Spring POJO");
	}

}
