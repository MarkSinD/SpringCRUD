package com.example.boot.test.test.service;


import com.example.boot.test.test.dao.InstructorDetailRepository;
import com.example.boot.test.test.dao.InstructorRepository;
import com.example.boot.test.test.entity.Instructor;
import com.example.boot.test.test.entity.InstructorDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class INSTRServiceImpl implements INSTRService {

	private InstructorRepository instructorRepository;
	private InstructorDetailRepository instructorDetailRepository;
	
	@Autowired
	public INSTRServiceImpl(InstructorRepository theInstructorRepository, InstructorDetailRepository theInstructorDetailRepository) {
		instructorRepository = theInstructorRepository;
		instructorDetailRepository = theInstructorDetailRepository;
	}

	@Override
	public List<Instructor> findAllInstructors() {
		return instructorRepository.findAllByOrderByLastNameAsc();
	}

	@Override
	public List<InstructorDetail> findAllInstructorDetails() {
		return instructorDetailRepository.findAllByOrderByHobbyAsc();
	}

	@Override
	public void saveInstructor(Instructor theInstructor) {
		instructorRepository.save(theInstructor);
	}

	@Override
	public void saveInstructorDetail(InstructorDetail theInstructorDetail) {
		instructorDetailRepository.save(theInstructorDetail);
	}

	@Override
	public void deleteByIdInstructor(int theId) {
		instructorRepository.deleteById(theId);
	}

	@Override
	public void deleteByIdInstructorDetail(int theId) {
		instructorDetailRepository.deleteById(theId);
	}

	@Override
	public Instructor findByIdInstructor(int theId) {
		Optional<Instructor> result = instructorRepository.findById(theId);

		Instructor theInstructor = null;

		if (result.isPresent()) {
			theInstructor = result.get();
		}
		else {
			throw new RuntimeException("Did not find employee id - " + theId);
		}
		return theInstructor;
	}

	@Override
	public InstructorDetail findByIdInstructorDetail(int theId) {
		Optional<InstructorDetail> result = instructorDetailRepository.findById(theId);

		InstructorDetail theInstructorDetail = null;

		if (result.isPresent()) {
			theInstructorDetail = result.get();
		}
		else {
			// we didn't find the employee
			throw new RuntimeException("Did not find employee id - " + theId);
		}

		return theInstructorDetail;
	}


}






