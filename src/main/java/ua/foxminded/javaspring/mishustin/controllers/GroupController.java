package ua.foxminded.javaspring.mishustin.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ua.foxminded.javaspring.mishustin.model.Group;
import ua.foxminded.javaspring.mishustin.service.GroupService;

import java.util.Optional;

@Controller
public class GroupController {

	private final GroupService groupService;

	@Autowired
	public GroupController(GroupService groupService) {
		this.groupService = groupService;
	}

	@GetMapping("/groups")
	public String showGroups(Model model) {
		model.addAttribute("groups", groupService.getAllGroups());
		return "groups";
	}

	@GetMapping("/groups/{groupId}")
	public String showGroupDetails(@PathVariable Integer groupId, Model model) {
		Optional<Group> group = groupService.getGroupById(groupId);
		model.addAttribute("group", group);
		return "group-details";
	}
}