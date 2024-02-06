package ua.foxminded.javaspring.mishustin.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ua.foxminded.javaspring.mishustin.model.Schedule;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Integer> {
	
	 @Query(value = "SELECT s FROM Schedule s JOIN FETCH s.group JOIN FETCH s.courseId JOIN FETCH s.timeScheduleId WHERE s.group.groupId = :groupId AND s.scheduleDate = :date")
	    List<Schedule> findScheduleByGroupAndDate(@Param("groupId") Integer groupId, @Param("date") LocalDate date);
}


