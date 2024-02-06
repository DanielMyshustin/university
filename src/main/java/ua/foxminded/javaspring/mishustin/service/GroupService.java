package ua.foxminded.javaspring.mishustin.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.foxminded.javaspring.mishustin.dao.GroupRepository;
import ua.foxminded.javaspring.mishustin.model.Group;

@Service
public class GroupService {

	@Autowired
	GroupRepository groupRepository;

	public Group createGroup(Group group) {
		return groupRepository.save(group);
	}

	public List<Group> getAllGroups() {
		return groupRepository.findAll();
	}

	public Optional<Group> getGroupById(Integer groupId) {
		return groupRepository.findById(groupId);
	}

	public Group updateGroup(Integer groupId, Group updatedGroup) {
		Optional<Group> existingGroup = groupRepository.findById(groupId);
		if (existingGroup.isPresent()) {
			updatedGroup.setGroupId(groupId);
			return groupRepository.save(updatedGroup);
		} else {
			return null;
		}
	}

	public void deleteGroup(Integer groupId) {
		groupRepository.deleteById(groupId);
	}

}
