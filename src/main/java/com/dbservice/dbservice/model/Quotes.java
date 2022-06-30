package com.dbservice.dbservice.model;

import java.util.List;


//This is Input Object (DTO Object)
public class Quotes {

	private String userName;
	private List<String> quotes;

	//Karthik -> AIRTEL,JIO,SBI,RELIANCE,SUZLON

	//Quotes quotes=new Quotes('kartik','AIRTEL,JIO,SBI,RELIANCE,SUZLON');

	//1 kartik AIRTEL
	//2 kartik JIO
	//3 kartik SBI
	//4 kartik RELIANCE
	//5 kartik SUZLON


	//for each (String: qutoes.getQuotes())
	//{
	// quotedao.save('karthink',String);
	//}
	public Quotes() {
	}

	public Quotes(String userName, List<String> quotes) {
		this.userName = userName;
		this.quotes = quotes;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public List<String> getQuotes() {
		return quotes;
	}

	public void setQuotes(List<String> quotes) {
		this.quotes = quotes;
	}
}
