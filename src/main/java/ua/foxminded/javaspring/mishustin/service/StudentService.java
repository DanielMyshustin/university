package ua.foxminded.javaspring.mishustin.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.foxminded.javaspring.mishustin.dao.StudentRepository;
import ua.foxminded.javaspring.mishustin.model.Student;

@Service
public class StudentService {

	@Autowired
	StudentRepository studentRepository;

	public Student createStudent(Student student) {
		return studentRepository.save(student);
	}

	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}

	public Optional<Student> getStudentById(Integer userId) {
		return studentRepository.findById(userId);
	}

	public Student updateStudent(Integer studentId, Student updatedStudent) {
		Optional<Student> existingStudent = studentRepository.findById(studentId);
		if (existingStudent.isPresent()) {
			updatedStudent.setStudentId(studentId);
			return studentRepository.save(updatedStudent);
		} else {
			return null;
		}
	}

	public void deleteStudent(Integer userId) {
		studentRepository.deleteById(userId);
	}
}
