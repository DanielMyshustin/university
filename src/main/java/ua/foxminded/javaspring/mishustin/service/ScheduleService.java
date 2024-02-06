package ua.foxminded.javaspring.mishustin.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.foxminded.javaspring.mishustin.dao.ScheduleRepository;
import ua.foxminded.javaspring.mishustin.model.Schedule;

@Service
public class ScheduleService {

	@Autowired
	ScheduleRepository scheduleRepository;

	public Schedule createSchedule(Schedule schedule) {
		return scheduleRepository.save(schedule);
	}

	public List<Schedule> getAllSchedules() {
		return scheduleRepository.findAll();
	}

	public Optional<Schedule> getScheduleById(Integer scheduleId) {
		return scheduleRepository.findById(scheduleId);
	}

	public Schedule updateSchedule(Integer scheduleId, Schedule updatedSchedule) {
		Optional<Schedule> existingSchedule = scheduleRepository.findById(scheduleId);
		if (existingSchedule.isPresent()) {
			updatedSchedule.setScheduleId(scheduleId);
			return scheduleRepository.save(updatedSchedule);
		} else {
			return null;
		}
	}
	
	 public List<Schedule> getScheduleByGroupAndDate(Integer groupId, LocalDate date) {
		    return scheduleRepository.findScheduleByGroupAndDate(groupId, date);
		  }

	public void deleteSchedule(Integer scheduleId) {
		scheduleRepository.deleteById(scheduleId);
	}
}
