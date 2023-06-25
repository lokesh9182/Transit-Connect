package com.klr.cc.Entity;

public class std {
	private String name;
	private int age;
	private String clg;
	
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}





	@Override
	public String toString() {
		return "std [name=" + name + ", age=" + age + ", clg=" + clg + "]";
	}


	public String getClg() {
		return clg;
	}


	public void setClg(String clg) {
		this.clg = clg;
	}


}
