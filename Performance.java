package com.project.hr.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the performance database table.
 * 
 */
@Entity
@NamedQuery(name="Performance.findAll", query="SELECT p FROM Performance p")
public class Performance implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private int performanceID;

	private int appraisalRating;

	@Lob
	private String comments;

	private String manager;

	@Temporal(TemporalType.DATE)
	private Date performanceDate;

	//bi-directional many-to-one association to Employee
	@ManyToOne
	@JoinColumn(name="employeeID")
	private Employee employee;

	public Performance() {
	}

	public int getPerformanceID() {
		return this.performanceID;
	}

	public void setPerformanceID(int performanceID) {
		this.performanceID = performanceID;
	}

	public int getAppraisalRating() {
		return this.appraisalRating;
	}

	public void setAppraisalRating(int appraisalRating) {
		this.appraisalRating = appraisalRating;
	}

	public String getComments() {
		return this.comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getManager() {
		return this.manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}

	public Date getPerformanceDate() {
		return this.performanceDate;
	}

	public void setPerformanceDate(Date performanceDate) {
		this.performanceDate = performanceDate;
	}

	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

}