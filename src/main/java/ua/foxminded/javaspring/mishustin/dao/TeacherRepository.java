package ua.foxminded.javaspring.mishustin.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.foxminded.javaspring.mishustin.model.Teacher;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Integer> {

}
