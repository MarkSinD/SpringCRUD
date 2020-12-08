package com.example.boot.test.test.service;

import com.example.boot.test.test.entity.Instructor;
import com.example.boot.test.test.entity.InstructorDetail;

import java.util.List;


public interface INSTRService {

	public List<Instructor> findAllInstructors();
	public List<InstructorDetail> findAllInstructorDetails();
	
	public Instructor findByIdInstructor(int theId);
	public InstructorDetail findByIdInstructorDetail(int theId);
	
	public void saveInstructor(Instructor theInstructor);
	public void saveInstructorDetail(InstructorDetail theInstructorDetail);
	
	public void deleteByIdInstructor(int theId);
	public void deleteByIdInstructorDetail(int theId);
	
}
