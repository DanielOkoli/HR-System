package com.project.hr.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the login database table.
 * 
 */
@Entity
@NamedQuery(name="Login.findAll", query="SELECT l FROM Login l")
public class Login implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private int loginID;

	private String password;

	private String username;

	//bi-directional many-to-one association to Employee
	@OneToOne 
	@JoinColumn(name="employeeID")
	private Employee employee;

	public Login() {
	}

	public int getLoginID() {
		return this.loginID;
	}

	public void setLoginID(int loginID) {
		this.loginID = loginID;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

}