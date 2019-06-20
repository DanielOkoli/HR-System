package com.project.hr.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the employee database table.
 * 
 */
@Entity
@NamedQuery(name="Employee.findAll", query="SELECT e FROM Employee e")
public class Employee implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private int employeeID;

	@Temporal(TemporalType.DATE)
	private Date dob;

	private String emailAddress;

	@Temporal(TemporalType.DATE)
	private Date endDate;

	private String firstName;

	private String gender;

	private String lastName;

	private String postCode;

	@Temporal(TemporalType.DATE)
	private Date startDate;

	private String streetName;

	private String telephone;

	//bi-directional many-to-one association to Emprole
	@ManyToOne(cascade={CascadeType.ALL})
	@JoinColumn(name="roleID")
	private Emprole emprole;

	//bi-directional many-to-one association to Project
	@ManyToOne
	@JoinColumn(name="projectID")
	private Project project;

	//bi-directional many-to-one association to History
	@OneToMany(mappedBy="employee")
	private List<History> histories;

	//bi-directional One-to-one association to Login
	@OneToOne (mappedBy= "employee")
	@JoinColumn(name="employeeID" )
	private Login logins;

	//bi-directional many-to-one association to Performance
	@OneToMany(mappedBy="employee")
	private List<Performance> performances;

	//bi-directional many-to-one association to Timetable
	@OneToMany(mappedBy="employee")
	private List<Timetable> timetables;

	//bi-directional many-to-one association to Vacation
	@OneToMany(mappedBy="employee")
	private List<Vacation> vacations;

	public Employee() {
	}

	public int getEmployeeID() {
		return this.employeeID;
	}

	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}

	public Date getDob() {
		return this.dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getEmailAddress() {
		return this.emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPostCode() {
		return this.postCode;
	}

	public String getStreetName() {
		return this.streetName;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Emprole getEmprole() {
		return this.emprole;
	}

	public void setEmprole(Emprole emprole) {
		this.emprole = emprole;
	}

	public Project getProject() {
		return this.project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public List<History> getHistories() {
		return this.histories;
	}

	public void setHistories(List<History> histories) {
		this.histories = histories;
	}

	public History addHistory(History history) {
		getHistories().add(history);
		history.setEmployee(this);

		return history;
	}

	public History removeHistory(History history) {
		getHistories().remove(history);
		history.setEmployee(null);

		return history;
	}

	public Login getLogins() {
		return this.logins;
	}

	public void setLogins(Login logins) {
		this.logins = logins;
	}

	@SuppressWarnings("unchecked")
	public Login addLogin(Login login) {
		((List<Login>) getLogins()).add(login);
		login.setEmployee(this);

		return login;
	}

	@SuppressWarnings("unchecked")
	public Login removeLogin(Login login) {
		((List<Login>) getLogins()).remove(login);
		login.setEmployee(null);

		return login;
	}

	public List<Performance> getPerformances() {
		return this.performances;
	}

	public void setPerformances(List<Performance> performances) {
		this.performances = performances;
	}

	public Performance addPerformance(Performance performance) {
		getPerformances().add(performance);
		performance.setEmployee(this);

		return performance;
	}

	public Performance removePerformance(Performance performance) {
		getPerformances().remove(performance);
		performance.setEmployee(null);

		return performance;
	}

	public List<Timetable> getTimetables() {
		return this.timetables;
	}

	public void setTimetables(List<Timetable> timetables) {
		this.timetables = timetables;
	}

	public Timetable addTimetable(Timetable timetable) {
		getTimetables().add(timetable);
		timetable.setEmployee(this);

		return timetable;
	}

	public Timetable removeTimetable(Timetable timetable) {
		getTimetables().remove(timetable);
		timetable.setEmployee(null);

		return timetable;
	}

	public List<Vacation> getVacations() {
		return this.vacations;
	}

	public void setVacations(List<Vacation> vacations) {
		this.vacations = vacations;
	}

	public Vacation addVacation(Vacation vacation) {
		getVacations().add(vacation);
		vacation.setEmployee(this);

		return vacation;
	}

	public Vacation removeVacation(Vacation vacation) {
		getVacations().remove(vacation);
		vacation.setEmployee(null);

		return vacation;
	}

}