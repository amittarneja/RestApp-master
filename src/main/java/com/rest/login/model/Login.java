package com.rest.login.model;
/**
 * Created by Amit on 2021/11/7
 * Login DAO getter and setter.
 */
public class Login {

	private String loginNo;
	private String loginName;
	private String loginSurname;

	public Login() {

	}

	public Login(String loginNo, String loginName, String loginSurname) {
		this.loginNo = loginNo;
		this.loginName = loginName;
		this.loginSurname = loginSurname;
	}

	public String getLoginNo() {
		return loginNo;
	}

	public void setLoginNo(String loginNo) {
		this.loginNo = loginNo;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getLoginSurname() {
		return loginSurname;
	}

	public void setLoginSsn(String loginSurname) {
		this.loginSurname = loginSurname;
	}

}