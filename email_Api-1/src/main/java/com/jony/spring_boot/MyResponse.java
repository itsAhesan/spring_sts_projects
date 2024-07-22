package com.jony.spring_boot;

import java.util.List;

public class MyResponse {

	String messge;
	List<MyModel> models;
	
	public String getMessge() {
		return messge;
	}
	public void setMessge(String messge) {
		this.messge = messge;
	}
	public List<MyModel> getModels() {
		return models;
	}
	public void setModels(List<MyModel> models) {
		this.models = models;
	}
	
}
