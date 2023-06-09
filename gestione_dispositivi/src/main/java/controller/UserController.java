package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import entity.User;
import exception.UserAlreadyPresentException;
import payload.UserPayload;
import service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;

	@GetMapping("/list")
	public ResponseEntity<List<User>> getUsers() {

		List<User> users = userService.listUser();
		return new ResponseEntity(users, HttpStatus.OK);
	}

	@GetMapping("/{username}")
	public ResponseEntity<User> getUser(@RequestParam String username) {

		User user1 = userService.user(username);

		if (user1 == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity(user1, HttpStatus.OK);

	}

	@PostMapping("/addUser")
	public ResponseEntity<String> addUser(@RequestBody UserPayload userPayload) {

		try {
			userService.addUser(userPayload);
			return new ResponseEntity("utente aggiunto correttamente", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity("impossibile aggiunge l'utente", HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@DeleteMapping("/delete/{username}")
	public ResponseEntity deleteUser(@RequestParam String username) {

		userService.deleteUser(username);
		return new ResponseEntity("utente eliminato correttamente", HttpStatus.OK);
	}

	@PutMapping("/put/{username}")
	public ResponseEntity<String> putUser(@RequestBody UserPayload userPayload) {

		try {
			userService.putUser(userPayload);
			return new ResponseEntity("utente aggiornato correttamente", HttpStatus.OK);
		} catch (UserAlreadyPresentException myException) {
			return new ResponseEntity("impossibile modificare l'utente", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}