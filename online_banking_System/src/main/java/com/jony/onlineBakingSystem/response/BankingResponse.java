package com.jony.onlineBakingSystem.response;

import java.util.List;

import org.springframework.stereotype.Component;

import com.jony.onlineBakingSystem.request.BankingModel;

@Component
public class BankingResponse {
	
	private Boolean error;
	private String msg;
	private List<BankingModel> bankDetails;
	
	
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
	public List<BankingModel> getBankDetails() {
		return bankDetails;
	}
	public void setBankDetails(List<BankingModel> bankDetails) {
		this.bankDetails = bankDetails;
	}
	
	
	
	
	

}
