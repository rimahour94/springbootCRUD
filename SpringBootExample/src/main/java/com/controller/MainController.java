package com.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.model.Student;
import com.repository.StudentRepository;

@RestController
public class MainController {

	@Autowired
	private StudentRepository StudentRepository;

	@PostMapping("/save_student")
	public Student saveStudent(@RequestBody Student student) {
		Student st = StudentRepository.save(student);
		return st;
	}

	@PostMapping("/save_students")
	public List<Student> saveStudents(@RequestBody List<Student> students) {
		List<Student> st = StudentRepository.saveAll(students);
		return st;
	}

	@GetMapping("/getAllStudent")
	public List<Student> getAllStudents() {
		List<Student> st = StudentRepository.findAll();
		return st;
	}

	@GetMapping("/getStudentById/{id}")
	public Student getStudentsById(@PathVariable("id") int id) {
		Student st = null;
		Optional<Student> student = StudentRepository.findById(id);
		if (student.isPresent()) {
			st = student.get();
		}
		return st;
	}

	@DeleteMapping("/deleteById/{delete}")
	public String deleteById(@PathVariable("delete") int id) {
		StudentRepository.deleteById(id);
		return "successfully";

	}

}
