package com.ezio.StudentMS.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ezio.StudentMS.entity.Student;
import com.ezio.StudentMS.service.StudentService;

@Controller
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@GetMapping("/home")
	public String home() {
		return "Home";
	}
	
	@PostMapping("/addDetails")
	@ResponseBody
	public Student addDetails(@RequestBody Student student) {
		return studentService.saveDetails(student);
	}
	
	@GetMapping("/getDetails")
	@ResponseBody
	public List<Student> showDetails(){
		return studentService.getDetails();
	}
	
	@GetMapping("/getDetails/{id}")
	@ResponseBody
	public Student showDetailById(@PathVariable Integer id) {
		return studentService.getDetailsById(id);
	}
	
	@PutMapping("/editDetails")
	@ResponseBody
	public Student updateDetails(@RequestBody Student student) {
		return studentService.editDetails(student);
	}
	
	@DeleteMapping("/deleteDetails/{id}")
	@ResponseBody
	public String removeDetails(@PathVariable Integer id) {
		return studentService.deleteDetails(id);
	}
}




