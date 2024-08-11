package com.mohit.jobportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mohit.jobportal.entity.JobSeekerProfile;

public interface JobSeekerProfileRepository extends JpaRepository<JobSeekerProfile, Integer> {

}
