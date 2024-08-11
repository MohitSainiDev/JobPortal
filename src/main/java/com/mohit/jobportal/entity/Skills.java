package com.mohit.jobportal.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "skills")
public class Skills {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;

	private String experinceLevel;

	private String yearsOfExperience;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "job_seeker_profile")
	private JobSeekerProfile jobSeekerProfile;

	public Skills() {
		super();
	}

	public Skills(int id, String name, String experinceLevel, String yearsOfExperience,
			JobSeekerProfile jobSeekerProfile) {
		super();
		this.id = id;
		this.name = name;
		this.experinceLevel = experinceLevel;
		this.yearsOfExperience = yearsOfExperience;
		this.jobSeekerProfile = jobSeekerProfile;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getExperinceLevel() {
		return experinceLevel;
	}

	public void setExperinceLevel(String experinceLevel) {
		this.experinceLevel = experinceLevel;
	}

	public String getYearsOfExperience() {
		return yearsOfExperience;
	}

	public void setYearsOfExperience(String yearsOfExperience) {
		this.yearsOfExperience = yearsOfExperience;
	}

	public JobSeekerProfile getJobSeekerProfile() {
		return jobSeekerProfile;
	}

	public void setJobSeekerProfile(JobSeekerProfile jobSeekerProfile) {
		this.jobSeekerProfile = jobSeekerProfile;
	}

	@Override
	public String toString() {
		return "Skills [id=" + id + ", name=" + name + ", experinceLevel=" + experinceLevel + ", yearsOfExperience="
				+ yearsOfExperience + ", jobSeekerProfile=" + jobSeekerProfile + "]";
	}

}
