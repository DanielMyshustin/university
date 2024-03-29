package ua.foxminded.javaspring.mishustin.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.foxminded.javaspring.mishustin.dao.TeacherRepository;
import ua.foxminded.javaspring.mishustin.model.Teacher;

@Service
public class TeacherService {

	@Autowired
	TeacherRepository teacherRepository;

	public Teacher createTeacher(Teacher teacher) {
		return teacherRepository.save(teacher);
	}

	public List<Teacher> getAllTeachers() {
		return teacherRepository.findAll();
	}

	public Optional<Teacher> getTeacherById(Integer userId) {
		return teacherRepository.findById(userId);
	}

	public Teacher updateTeacher(Integer teacherId, Teacher updatedTeacher) {
		Optional<Teacher> existingTeacher = teacherRepository.findById(teacherId);
		if (existingTeacher.isPresent()) {
			updatedTeacher.setTeacherId(teacherId);
			return teacherRepository.save(updatedTeacher);
		} else {
			return null;
		}
	}

	public void deleteTeacher(Integer userId) {
		teacherRepository.deleteById(userId);
	}
	
	public Optional<Teacher> findByLogin(String login) {
        return teacherRepository.findByLogin(login);
    }
}
