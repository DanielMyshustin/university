package ua.foxminded.javaspring.mishustin.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ua.foxminded.javaspring.mishustin.model.Schedule;
import ua.foxminded.javaspring.mishustin.service.ScheduleService;

import java.util.Optional;

@Controller
public class ScheduleController {

	private final ScheduleService scheduleService;

	@Autowired
	public ScheduleController(ScheduleService scheduleService) {
		this.scheduleService = scheduleService;
	}

	@GetMapping("/schedules")
	public String showSchedules(Model model) {
		model.addAttribute("schedules", scheduleService.getAllSchedules());
		return "schedules";
	}

	@GetMapping("/schedules/{scheduleId}")
	public String showScheduleDetails(@PathVariable Integer scheduleId, Model model) {
		Optional<Schedule> schedule = scheduleService.getScheduleById(scheduleId);
		model.addAttribute("schedule", schedule);
		return "schedule-details";
	}
}
