package container.exception;

public class UserAlreadyPresentException extends RuntimeException {

	public UserAlreadyPresentException() {
		super("spiacente, l'utente è già esistente nel database");
	}

}
