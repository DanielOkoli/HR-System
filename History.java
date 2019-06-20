package com.project.hr.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the history database table.
 * 
 */
@Entity
@NamedQuery(name="History.findAll", query="SELECT h FROM History h")
public class History implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private int historyID;

	@Temporal(TemporalType.DATE)
	private Date commenceDate;

	//bi-directional many-to-one association to Employee
	@ManyToOne
	@JoinColumn(name="employeeID")
	private Employee employee;

	//bi-directional many-to-one association to Emprole
	@ManyToOne
	@JoinColumn(name="roleID")
	private Emprole emprole;

	//bi-directional many-to-one association to Grade
	@ManyToOne
	@JoinColumn(name="gradeID")
	private Grade grade;

	public History() {
	}

	public int getHistoryID() {
		return this.historyID;
	}

	public void setHistoryID(int historyID) {
		this.historyID = historyID;
	}

	public Date getCommenceDate() {
		return this.commenceDate;
	}

	public void setCommenceDate(Date commenceDate) {
		this.commenceDate = commenceDate;
	}

	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Emprole getEmprole() {
		return this.emprole;
	}

	public void setEmprole(Emprole emprole) {
		this.emprole = emprole;
	}

	public Grade getGrade() {
		return this.grade;
	}

	public void setGrade(Grade grade) {
		this.grade = grade;
	}

}