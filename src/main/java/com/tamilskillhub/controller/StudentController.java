package com.tamilskillhub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tamilskillhub.entity.Student;
import com.tamilskillhub.service.StudentService;

@RestController
@RequestMapping("/api")
public class StudentController {

	@Autowired
	StudentService studentService;

	@GetMapping("/welcome")
	public String welcome() {
		return "Welcome to Tamil Skillhub!";
	}

	@PostMapping("/student")
	public ResponseEntity<?> addStudent(@RequestBody Student student) {
		student = studentService.addStudent(student);
		return ResponseEntity.ok(student);

	}

	@GetMapping("/students")
	public ResponseEntity<?> getAllStudents() {
		return ResponseEntity.ok(studentService.getAllStudents());
	}

	@GetMapping("/student/{id}")
	public ResponseEntity<?> getStudent(@PathVariable Long id) {
		return ResponseEntity.ok(studentService.getStudent(id));
	}

	@DeleteMapping("/student/{id}")
	public String deleteStudent(@PathVariable Long id) {
		return studentService.deleteStudent(id);
	}

	@PutMapping("/student/{id}")
	public ResponseEntity<?> updateStudent(@PathVariable Long id, @RequestBody Student student) {
		return ResponseEntity.ok(studentService.updateStudent(student, id));
	}
}
