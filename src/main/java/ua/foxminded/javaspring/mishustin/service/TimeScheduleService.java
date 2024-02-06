package ua.foxminded.javaspring.mishustin.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.foxminded.javaspring.mishustin.dao.TimeScheduleRepository;
import ua.foxminded.javaspring.mishustin.model.TimeSchedule;

@Service
public class TimeScheduleService {

	@Autowired
	TimeScheduleRepository timeScheduleRepository;

	public TimeSchedule createTimeSchedule(TimeSchedule timeSchedule) {
		return timeScheduleRepository.save(timeSchedule);
	}

	public List<TimeSchedule> getAllTimeSchedules() {
		return timeScheduleRepository.findAll();
	}

	public Optional<TimeSchedule> getTimeScheduleById(Integer timeScheduleId) {
		return timeScheduleRepository.findById(timeScheduleId);
	}

	public TimeSchedule updateTimeSchedule(Integer timeScheduleId, TimeSchedule updatedTimeSchedule) {
		Optional<TimeSchedule> existingTimeSchedule = timeScheduleRepository.findById(timeScheduleId);
		if (existingTimeSchedule.isPresent()) {
			updatedTimeSchedule.setTimeScheduleId(timeScheduleId);
			return timeScheduleRepository.save(updatedTimeSchedule);
		} else {
			return null;
		}
	}

	public void deleteTimeSchedule(Integer timeScheduleId) {
		timeScheduleRepository.deleteById(timeScheduleId);
	}
}
