package com.project.hr.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the department database table.
 * 
 */
@Entity
@NamedQuery(name="Department.findAll", query="SELECT d FROM Department d")
public class Department implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private int departmentID;

	private String departmentName;

	//bi-directional many-to-one association to Emprole
	@OneToMany(mappedBy="department")
	private List<Emprole> emproles;

	//bi-directional many-to-one association to Project
	@OneToMany(mappedBy="department")
	private List<Project> projects;

	public Department() {
	}

	public int getDepartmentID() {
		return this.departmentID;
	}

	public void setDepartmentID(int departmentID) {
		this.departmentID = departmentID;
	}

	public String getDepartmentName() {
		return this.departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public List<Emprole> getEmproles() {
		return this.emproles;
	}

	public void setEmproles(List<Emprole> emproles) {
		this.emproles = emproles;
	}

	public Emprole addEmprole(Emprole emprole) {
		getEmproles().add(emprole);
		emprole.setDepartment(this);

		return emprole;
	}

	public Emprole removeEmprole(Emprole emprole) {
		getEmproles().remove(emprole);
		emprole.setDepartment(null);

		return emprole;
	}

	public List<Project> getProjects() {
		return this.projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	public Project addProject(Project project) {
		getProjects().add(project);
		project.setDepartment(this);

		return project;
	}

	public Project removeProject(Project project) {
		getProjects().remove(project);
		project.setDepartment(null);

		return project;
	}

}