package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import entity.User;
import exception.UserAlreadyPresentException;
import payload.UserPayload;
import repository.UserRepository;

public class UserService {

	@Autowired
	private UserRepository userRepository;

	public List<User> listUser() {

		return userRepository.findAll();

	}

//qui il controller(l'utente ci andrà a mettere lo username che cerca)
	public User user(String username) {

		return userRepository.getReferenceById(username);

	}

	public void deleteUser(String username) {

		userRepository.deleteById(username);
	}

	public void addUser(UserPayload userPayload) throws Exception {

		User user1 = user(userPayload.getUsername());

		if (user1 == null) {
			User user = new User();

			user.setUsername(userPayload.getUsername());
			user.setName(userPayload.getName());
			user.setSurname(userPayload.getSurname());
			user.setEmail(userPayload.getEmail());

			userRepository.save(user);
		} else {
			throw new UserAlreadyPresentException();
		}

	}

	public void putUser(UserPayload userPayload) throws UserAlreadyPresentException {

		User user = user(userPayload.getUsername());

		if (user != null) {

			user.setName(userPayload.getName());
			user.setSurname(userPayload.getSurname());
			user.setEmail(userPayload.getEmail());
			userRepository.save(user);
		} else {
			throw new UserAlreadyPresentException();
		}
	}

}
