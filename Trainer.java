package com.project.hr.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the trainer database table.
 * 
 */
@Entity
@NamedQuery(name="Trainer.findAll", query="SELECT t FROM Trainer t")
public class Trainer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private int trainerID;

	private String trainerName;

	//bi-directional many-to-one association to Timetable
	@OneToMany(mappedBy="trainer")
	private List<Timetable> timetables;

	public Trainer() {
	}

	public int getTrainerID() {
		return this.trainerID;
	}

	public void setTrainerID(int trainerID) {
		this.trainerID = trainerID;
	}

	public String getTrainerName() {
		return this.trainerName;
	}

	public void setTrainerName(String trainerName) {
		this.trainerName = trainerName;
	}

	public List<Timetable> getTimetables() {
		return this.timetables;
	}

	public void setTimetables(List<Timetable> timetables) {
		this.timetables = timetables;
	}

	public Timetable addTimetable(Timetable timetable) {
		getTimetables().add(timetable);
		timetable.setTrainer(this);

		return timetable;
	}

	public Timetable removeTimetable(Timetable timetable) {
		getTimetables().remove(timetable);
		timetable.setTrainer(null);

		return timetable;
	}

}