package com.ezio.StudentMS.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezio.StudentMS.entity.Student;
import com.ezio.StudentMS.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;
	
	public Student saveDetails(Student student) {
		return studentRepository.save(student);
	}
	
	public List<Student> getDetails(){
		return studentRepository.findAll();
	}
	
	public Student getDetailsById(Integer id) {
		return studentRepository.findById(id).orElse(null);
	}
	
	public Student editDetails(Student student) {
		Student existingStudent = studentRepository.findById(student.getId()).orElse(null);
		if (existingStudent!=null) {
			existingStudent.setName(student.getName());
			existingStudent.setGmail(student.getGmail());
			existingStudent.setContact(student.getContact());
			existingStudent.setCourse(student.getCourse());
			existingStudent.setFees(student.getFees());
			return studentRepository.save(existingStudent);
		}
		return null;
	}
	
	public String deleteDetails(Integer id) {
		studentRepository.deleteById(id);
		return "Record deleted successfully...";
	}
}
