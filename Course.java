package com.project.hr.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the course database table.
 * 
 */
@Entity
@NamedQuery(name="Course.findAll", query="SELECT c FROM Course c")
public class Course implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private int courseID;

	private int courseCredits;

	private String courseTitle;

	//bi-directional many-to-one association to Module
	@OneToMany(mappedBy="course")
	private List<Module> modules;

	//bi-directional many-to-one association to Timetable
	@OneToMany(mappedBy="course")
	private List<Timetable> timetables;

	public Course() {
	}

	public int getCourseID() {
		return this.courseID;
	}

	public void setCourseID(int courseID) {
		this.courseID = courseID;
	}

	public int getCourseCredits() {
		return this.courseCredits;
	}

	public void setCourseCredits(int courseCredits) {
		this.courseCredits = courseCredits;
	}

	public String getCourseTitle() {
		return this.courseTitle;
	}

	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}

	public List<Module> getModules() {
		return this.modules;
	}

	public void setModules(List<Module> modules) {
		this.modules = modules;
	}

	public Module addModule(Module module) {
		getModules().add(module);
		module.setCourse(this);

		return module;
	}

	public Module removeModule(Module module) {
		getModules().remove(module);
		module.setCourse(null);

		return module;
	}

	public List<Timetable> getTimetables() {
		return this.timetables;
	}

	public void setTimetables(List<Timetable> timetables) {
		this.timetables = timetables;
	}

	public Timetable addTimetable(Timetable timetable) {
		getTimetables().add(timetable);
		timetable.setCourse(this);

		return timetable;
	}

	public Timetable removeTimetable(Timetable timetable) {
		getTimetables().remove(timetable);
		timetable.setCourse(null);

		return timetable;
	}

}