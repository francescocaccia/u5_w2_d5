package service;

import org.springframework.beans.factory.annotation.Autowired;

import repository.UserRepository;

public class DevicesService {
	@Autowired
	private UserRepository userRepository;

}
