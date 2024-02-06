package ua.foxminded.javaspring.mishustin.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ua.foxminded.javaspring.mishustin.model.TimeSchedule;

@Repository
public interface TimeScheduleRepository extends JpaRepository<TimeSchedule, Integer> {

}
