package ua.foxminded.javaspring.mishustin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.foxminded.javaspring.mishustin.dao.UserRepository;
import ua.foxminded.javaspring.mishustin.model.User;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	public User createUser(User user) {
		return userRepository.save(user);
	}

	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	public Optional<User> getUserById(Integer userId) {
		return userRepository.findById(userId);
	}

	public User updateUser(Integer userId, User updatedUser) {
		Optional<User> existingUser = userRepository.findById(userId);
		if (existingUser.isPresent()) {
			updatedUser.setUserId(userId);
			return userRepository.save(updatedUser);
		} else {
			return null;
		}
	}

	public void deleteUser(Integer userId) {
		userRepository.deleteById(userId);
	}
}
