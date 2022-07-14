package com.greatlearning.studentmanagement.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.greatlearning.studentmanagement.entity.Student;
import com.greatlearning.studentmanagement.service.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@RequestMapping("/list")
	public String listStudents(Model theModel) {
		List<Student> theStudents = studentService.findAll();
		
		theModel.addAttribute("students", theStudents);
		
		return "list-students";
	}
	
	@RequestMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		Student theStudent = new Student();
		theModel.addAttribute("student", theStudent);
		return "student-form";
	}
	
	@RequestMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("studentId") int theId,
			Model theModel) {
		Student theStudent = studentService.findById(theId);
		theModel.addAttribute("student", theStudent);
		
		return "student-form";
	}
	
	@PostMapping("/save")
	public String saveStudent(@RequestParam("id") int id,
			@RequestParam("firstName") String firstName,@RequestParam("lastName") String lastName,
			@RequestParam("course") String course,@RequestParam("country") String country) {
		
		Student thestudent;
		if(id!=0) {
			thestudent=studentService.findById(id);
			thestudent.setFirstName(firstName);
			thestudent.setLastName(lastName);
			thestudent.setCourse(course);
			thestudent.setCountry(country);
		}
		else
			thestudent = new Student(firstName, lastName, course, country);
		
		studentService.save(thestudent);
		
		return "redirect:/student/list";
	}
	
	@RequestMapping("/delete")
	public String delete(@RequestParam("studentId") int theId) {
		studentService.deleteById(theId);
		
		return "redirect:/student/list";
	}
	
	@RequestMapping(value="/403")
	public ModelAndView accessDenied(Principal user) {
		ModelAndView model = new ModelAndView();
		
		if(user != null) {
			model.addObject("msg", "Hello "+user.getName()+",dont have permission to access this page");
		}else {
			model.addObject("msg", "not have the permission to access this page");
		}
		
		model.setViewName("403");
		return model;
		
	}
		
	
	

}
