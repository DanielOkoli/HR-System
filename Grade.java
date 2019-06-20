package com.project.hr.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the grade database table.
 * 
 */
@Entity
@NamedQuery(name="Grade.findAll", query="SELECT g FROM Grade g")
public class Grade implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private int gradeID;

	private String grade;

	private BigDecimal salary;

	private String subGrade;

	//bi-directional many-to-one association to History
	@OneToMany(mappedBy="grade")
	private List<History> histories;

	public Grade() {
	}

	public int getGradeID() {
		return this.gradeID;
	}

	public void setGradeID(int gradeID) {
		this.gradeID = gradeID;
	}

	public String getGrade() {
		return this.grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public BigDecimal getSalary() {
		return this.salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

	public String getSubGrade() {
		return this.subGrade;
	}

	public void setSubGrade(String subGrade) {
		this.subGrade = subGrade;
	}

	public List<History> getHistories() {
		return this.histories;
	}

	public void setHistories(List<History> histories) {
		this.histories = histories;
	}

	public History addHistory(History history) {
		getHistories().add(history);
		history.setGrade(this);

		return history;
	}

	public History removeHistory(History history) {
		getHistories().remove(history);
		history.setGrade(null);

		return history;
	}

}