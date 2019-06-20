package com.project.hr.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the emprole database table.
 * 
 */
@Entity
@NamedQuery(name="Emprole.findAll", query="SELECT e FROM Emprole e")
public class Emprole implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private int roleID;

	private String roleName;

	//bi-directional many-to-one association to Employee
	@OneToMany(mappedBy="emprole", cascade={CascadeType.ALL})
	private List<Employee> employees;

	//bi-directional many-to-one association to Department
	@ManyToOne
	@JoinColumn(name="departmentID")
	private Department department;

	//bi-directional many-to-one association to History
	@OneToMany(mappedBy="emprole")
	private List<History> histories;

	public Emprole() {
	}

	public int getRoleID() {
		return this.roleID;
	}

	public void setRoleID(int roleID) {
		this.roleID = roleID;
	}

	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public List<Employee> getEmployees() {
		return this.employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public Employee addEmployee(Employee employee) {
		getEmployees().add(employee);
		employee.setEmprole(this);

		return employee;
	}

	public Employee removeEmployee(Employee employee) {
		getEmployees().remove(employee);
		employee.setEmprole(null);

		return employee;
	}

	public Department getDepartment() {
		return this.department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public List<History> getHistories() {
		return this.histories;
	}

	public void setHistories(List<History> histories) {
		this.histories = histories;
	}

	public History addHistory(History history) {
		getHistories().add(history);
		history.setEmprole(this);

		return history;
	}

	public History removeHistory(History history) {
		getHistories().remove(history);
		history.setEmprole(null);

		return history;
	}

}