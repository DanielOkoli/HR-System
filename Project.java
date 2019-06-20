package com.project.hr.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the project database table.
 * 
 */
@Entity
@NamedQuery(name="Project.findAll", query="SELECT p FROM Project p")
public class Project implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private int projectID;

	@Temporal(TemporalType.DATE)
	private Date dateCompleted;

	@Temporal(TemporalType.DATE)
	private Date estimatedFinish;

	private String numEmployee;

	private String projectName;

	@Temporal(TemporalType.DATE)
	private Date startDate;

	private String status;

	//bi-directional many-to-one association to Employee
	@OneToMany(mappedBy="project")
	private List<Employee> employees;

	//bi-directional many-to-one association to Department
	@ManyToOne
	@JoinColumn(name="departmentID")
	private Department department;

	public Project() {
	}

	public int getProjectID() {
		return this.projectID;
	}

	public void setProjectID(int projectID) {
		this.projectID = projectID;
	}

	public Date getDateCompleted() {
		return this.dateCompleted;
	}

	public void setDateCompleted(Date dateCompleted) {
		this.dateCompleted = dateCompleted;
	}

	public Date getEstimatedFinish() {
		return this.estimatedFinish;
	}

	public void setEstimatedFinish(Date estimatedFinish) {
		this.estimatedFinish = estimatedFinish;
	}

	public String getNumEmployee() {
		return this.numEmployee;
	}

	public void setNumEmployee(String numEmployee) {
		this.numEmployee = numEmployee;
	}

	public String getProjectName() {
		return this.projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<Employee> getEmployees() {
		return this.employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public Employee addEmployee(Employee employee) {
		getEmployees().add(employee);
		employee.setProject(this);

		return employee;
	}

	public Employee removeEmployee(Employee employee) {
		getEmployees().remove(employee);
		employee.setProject(null);

		return employee;
	}

	public Department getDepartment() {
		return this.department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

}