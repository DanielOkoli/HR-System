package com.project.hr.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the vacation database table.
 * 
 */
@Entity
@NamedQuery(name="Vacation.findAll", query="SELECT v FROM Vacation v")
public class Vacation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private int vacationID;

	private String remainingDays;

	private String usedDays;

	@Temporal(TemporalType.DATE)
	private Date vEndDate;

	@Temporal(TemporalType.DATE)
	private Date vStartDate;

	//bi-directional many-to-one association to Employee
	@ManyToOne
	@JoinColumn(name="employeeID")
	private Employee employee;

	public Vacation() {
	}

	public int getVacationID() {
		return this.vacationID;
	}

	public void setVacationID(int vacationID) {
		this.vacationID = vacationID;
	}

	public String getRemainingDays() {
		return this.remainingDays;
	}

	public void setRemainingDays(String remainingDays) {
		this.remainingDays = remainingDays;
	}

	public String getUsedDays() {
		return this.usedDays;
	}

	public void setUsedDays(String usedDays) {
		this.usedDays = usedDays;
	}

	public Date getVEndDate() {
		return this.vEndDate;
	}

	public void setVEndDate(Date vEndDate) {
		this.vEndDate = vEndDate;
	}

	public Date getVStartDate() {
		return this.vStartDate;
	}

	public void setVStartDate(Date vStartDate) {
		this.vStartDate = vStartDate;
	}

	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

}