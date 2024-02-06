package ua.foxminded.javaspring.mishustin.controllers;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import ua.foxminded.javaspring.mishustin.model.Group;
import ua.foxminded.javaspring.mishustin.service.GroupService;

@Controller
public class GroupController {

	private final GroupService groupService;

	@Autowired
	public GroupController(GroupService groupService) {
		this.groupService = groupService;
	}

	@GetMapping("/groups")
	public String showGroups(Model model) {
	    List<Group> groups = groupService.getAllGroups();
	    model.addAttribute("groups", groups);
	    return "groups";
	}

	@GetMapping("/groups/{groupId}")
	public String showGroupDetails(@PathVariable Integer groupId, Model model) {
	    Optional<Group> groupOptional = groupService.getGroupById(groupId);
	    
	    if (groupOptional.isPresent()) {
	        Group group = groupOptional.get();
	        model.addAttribute("group", group);
	    } else {
	    	System.out.println("Data not found.");
	    }

	    return "group-details";
	}
}