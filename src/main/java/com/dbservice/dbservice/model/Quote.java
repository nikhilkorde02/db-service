package com.dbservice.dbservice.model;

import javax.persistence.*;

@Entity
@Table(name = "quotes")
//This is Persistent Object which has JPA Annotations
public class Quote {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;


	//Arun Stock1,Stock2,Stock3
	//1 Arun Stock1
	//2 Arun Stock2
	//3 Arun Stock3

	@Column(name = "user_name")
	private String userName;

	@Column(name = "quote")
	private String quote;

	public Quote() {
	}

	public Quote(String userName, String quote) {
		this.userName = userName;
		this.quote = quote;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getQuote() {
		return quote;
	}

	public void setQuote(String quote) {
		this.quote = quote;
	}
}
