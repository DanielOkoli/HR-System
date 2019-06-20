package com.project.hr.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the timetable database table.
 * 
 */
@Entity
@NamedQuery(name="Timetable.findAll", query="SELECT t FROM Timetable t")
public class Timetable implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private int timetableID;

	@Temporal(TemporalType.DATE)
	private Date tEndDate;

	@Temporal(TemporalType.DATE)
	private Date tStartDate;

	//bi-directional many-to-one association to Course
	@ManyToOne
	@JoinColumn(name="courseID")
	private Course course;

	//bi-directional many-to-one association to Employee
	@ManyToOne
	@JoinColumn(name="employeeID")
	private Employee employee;

	//bi-directional many-to-one association to Trainer
	@ManyToOne
	@JoinColumn(name="trainerID")
	private Trainer trainer;

	public Timetable() {
	}

	public int getTimetableID() {
		return this.timetableID;
	}

	public void setTimetableID(int timetableID) {
		this.timetableID = timetableID;
	}

	public Date getTEndDate() {
		return this.tEndDate;
	}

	public void setTEndDate(Date tEndDate) {
		this.tEndDate = tEndDate;
	}

	public Date getTStartDate() {
		return this.tStartDate;
	}

	public void setTStartDate(Date tStartDate) {
		this.tStartDate = tStartDate;
	}

	public Course getCourse() {
		return this.course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Trainer getTrainer() {
		return this.trainer;
	}

	public void setTrainer(Trainer trainer) {
		this.trainer = trainer;
	}

}