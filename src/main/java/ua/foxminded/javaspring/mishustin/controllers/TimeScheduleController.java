package ua.foxminded.javaspring.mishustin.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ua.foxminded.javaspring.mishustin.model.TimeSchedule;
import ua.foxminded.javaspring.mishustin.service.TimeScheduleService;

import java.util.Optional;

@Controller
public class TimeScheduleController {

	private final TimeScheduleService timeScheduleService;

	@Autowired
	public TimeScheduleController(TimeScheduleService timeScheduleService) {
		this.timeScheduleService = timeScheduleService;
	}

	@GetMapping("/time-schedules")
	public String showTimeSchedules(Model model) {
		model.addAttribute("timeSchedules", timeScheduleService.getAllTimeSchedules());
		return "time-schedules";
	}

	@GetMapping("/time-schedules/{timeScheduleId}")
	public String showTimeScheduleDetails(@PathVariable Integer timeScheduleId, Model model) {
		Optional<TimeSchedule> timeSchedule = timeScheduleService.getTimeScheduleById(timeScheduleId);
		model.addAttribute("timeSchedule", timeSchedule);
		return "time-schedule-details";
	}
}
