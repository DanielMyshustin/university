package ua.foxminded.javaspring.mishustin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.foxminded.javaspring.mishustin.dao.StudentRepository;
import ua.foxminded.javaspring.mishustin.model.Student;

import java.util.List;
import java.util.Optional;

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

	public Student updateStudent(Integer userId, Student updatedStudent) {
		Optional<Student> existingStudent = studentRepository.findById(userId);
		if (existingStudent.isPresent()) {
			updatedStudent.setUserId(userId);
			return studentRepository.save(updatedStudent);
		} else {
			return null;
		}
	}

	public void deleteStudent(Integer userId) {
		studentRepository.deleteById(userId);
	}
}
