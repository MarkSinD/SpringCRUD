package com.example.boot.test.test.controller;

import com.example.boot.test.test.entity.Instructor;
import com.example.boot.test.test.service.INSTRService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/instructor")
public class InstructorController {

	private INSTRService INSTRService;

	public InstructorController(INSTRService theInstructorService) {
		INSTRService = theInstructorService;
	}

	@GetMapping("/list")
	public String listEmployees(Model theModel) {
		List<Instructor> theStudents = INSTRService.findAllInstructors();
		theModel.addAttribute("instructor", theStudents);
		return "instructor/list-instructor";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		Instructor theInstructor = new Instructor();
		theModel.addAttribute("instructor", theInstructor);
		return "instructor/instructor-form";
	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("instructorId") int theId, Model theModel) {
		Instructor theInstructor = INSTRService.findByIdInstructor(theId);
		theModel.addAttribute("instructor", theInstructor);
		return "instructor/instructor-form";
	}

	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("instructor") Instructor theInstructor) {

		INSTRService.saveInstructor(theInstructor);
		return "redirect:/instructor/list";
	}

	@GetMapping("/delete")
	public String delete(@RequestParam("instructorId") int theId) {
		INSTRService.deleteByIdInstructor(theId);
		return "redirect:/instructor/list";
		
	}
}


















