package com.example.boot.test.test.controller;

import com.example.boot.test.test.entity.Instructor;
import com.example.boot.test.test.entity.InstructorDetail;
import com.example.boot.test.test.service.INSTRService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/instructorDetail")
public class InstructorDetailController {

    private INSTRService INSTRService;

    public InstructorDetailController(INSTRService theInstructorService) {
        INSTRService = theInstructorService;
    }

    @GetMapping("/list")
    public String listEmployees(Model theModel) {
        List<InstructorDetail> theInstructorDetail = INSTRService.findAllInstructorDetails();
        theModel.addAttribute("instructorDetail", theInstructorDetail);
        return "instructor/list-instructor-detail";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {
        InstructorDetail theInstructorDetail = new InstructorDetail();
        theModel.addAttribute("instructorDetail", theInstructorDetail);
        return "instructor/instructor-detail-form";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("instructorDetailId") int theId, Model theModel) {
        InstructorDetail theInstructorDetail = INSTRService.findByIdInstructorDetail(theId);
        theModel.addAttribute("instructorDetail", theInstructorDetail);
        System.out.println(theInstructorDetail);
        return "instructor/instructor-detail-form";
    }


    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("instructorDetail") InstructorDetail theInstructorDetail) {
        INSTRService.saveInstructorDetail(theInstructorDetail);
        return "redirect:/instructorDetail/list";
    }


    @GetMapping("/delete")
    public String delete(@RequestParam("instructorDetailId") int theId) {
        INSTRService.deleteByIdInstructorDetail(theId);
        return "redirect:/instructorDetail/list";
    }
}


















