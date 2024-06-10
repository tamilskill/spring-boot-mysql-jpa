package com.tamilskillhub.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tamilskillhub.entity.Student;
import com.tamilskillhub.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	StudentRepository studentRepository;

	public Student addStudent(Student student) {
		return studentRepository.save(student);
	}

	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}

	public Student getStudent(Long id) {
		return studentRepository.findById(id).orElse(null);
	}

	public String deleteStudent(Long id) {
		studentRepository.deleteById(id);
		return "student deleted successfully";
	}

	public Student updateStudent(Student student, Long id) {
		Student existingStudent = studentRepository.findById(id).orElse(null);
		if (existingStudent != null) {
			student.setId(existingStudent.getId());
			if (student.getName() == null) {
				student.setName(existingStudent.getName());
			}
			if (student.getDepartment() == null) {
				student.setDepartment(existingStudent.getDepartment());
			}
		}
		return studentRepository.save(student);
	}
}
