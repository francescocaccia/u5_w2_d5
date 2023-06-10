package service;

import java.util.List;
import java.util.Optional;

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

//qui il controller/l'utente ci andrà a mettere lo username che cerca)
	public Optional<User> getByUsername(String username) {

		return userRepository.findById(username);

	}

	public void deleteUser(String username) {

		userRepository.deleteById(username);
	}

	public void addUser(UserPayload userPayload) throws Exception {

		Optional<User> user1 = getByUsername(userPayload.getUsername());

		if (user1.isEmpty()) {
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

		Optional<User> user = getByUsername(userPayload.getUsername());

		if (user.isPresent()) {
			User user1 = user.get();
			user1.setName(userPayload.getName());
			user1.setSurname(userPayload.getSurname());
			user1.setEmail(userPayload.getEmail());
			userRepository.save(user1);
		} else {
			throw new UserAlreadyPresentException();
		}
	}

}
