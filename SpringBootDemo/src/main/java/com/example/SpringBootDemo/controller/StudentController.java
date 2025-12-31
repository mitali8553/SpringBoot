package com.example.SpringBootDemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.SpringBootDemo.model.Student;
import com.example.SpringBootDemo.service.StudentService;

@Controller
public class StudentController {

	private final StudentService service;

	public StudentController(StudentService service) {
		super();
		this.service = service;
	}
	
	@GetMapping("/")
	public String viewHomePage(Model model) {
		model.addAttribute("listStudents",service.getAllStudents());
		return "list";
	}
	
	@GetMapping("/showNewStudentForm")
	public String showNewStudentForm(Model model) {
		model.addAttribute("student", new Student());
				 return "add";
	}
	
	@PostMapping("/save")
	public String saveStudent(@ModelAttribute("student") Student student) {
		service.saveStudent(student);
		return "redirect:/";
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable Long id, Model model) {
	    model.addAttribute("student", service.getStudentById(id));
	    return "edit-student";
	}
	
	@PostMapping("/update/{id}")
	public String update(@PathVariable Long id, @ModelAttribute Student student) {
		student.setId(id);
		service.saveStudent(student);
		return "redirect:/";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Long id) {
	    service.deleteStudent(id);
	    return "redirect:/";
	}

}
