package com.jony.spring_boot.response;

import java.util.List;

import org.springframework.stereotype.Component;

import com.jony.spring_boot.request.Books;

@Component
public class BooksResponse {
	
	private Boolean error;
	private String msg;
	private List<Books> book;
	
	
	public Boolean getError() {
		return error;
	}
	public void setError(Boolean error) {
		this.error = error;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public List<Books> getBook() {
		return book;
	}
	public void setBook(List<Books> book) {
		this.book = book;
	}
	
	
	

}
