package com.project.hr.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the module database table.
 * 
 */
@Entity
@NamedQuery(name="Module.findAll", query="SELECT m FROM Module m")
public class Module implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private int moduleID;

	private BigDecimal cost;

	private int moduleCredits;

	private String moduleTitle;

	//bi-directional many-to-one association to Course
	@ManyToOne
	@JoinColumn(name="courseID")
	private Course course;

	public Module() {
	}

	public int getModuleID() {
		return this.moduleID;
	}

	public void setModuleID(int moduleID) {
		this.moduleID = moduleID;
	}

	public BigDecimal getCost() {
		return this.cost;
	}

	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}

	public int getModuleCredits() {
		return this.moduleCredits;
	}

	public void setModuleCredits(int moduleCredits) {
		this.moduleCredits = moduleCredits;
	}

	public String getModuleTitle() {
		return this.moduleTitle;
	}

	public void setModuleTitle(String moduleTitle) {
		this.moduleTitle = moduleTitle;
	}

	public Course getCourse() {
		return this.course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

}