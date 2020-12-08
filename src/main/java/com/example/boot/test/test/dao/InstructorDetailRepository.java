package com.example.boot.test.test.dao;

import com.example.boot.test.test.entity.InstructorDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InstructorDetailRepository  extends JpaRepository<InstructorDetail, Integer> {
    public List<InstructorDetail> findAllByOrderByHobbyAsc();
}
