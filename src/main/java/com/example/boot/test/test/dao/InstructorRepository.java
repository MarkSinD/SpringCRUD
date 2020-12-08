package com.example.boot.test.test.dao;


import com.example.boot.test.test.entity.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface InstructorRepository extends JpaRepository<Instructor, Integer> {
	public List<Instructor> findAllByOrderByLastNameAsc();
}
