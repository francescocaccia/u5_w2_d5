package container.configuration;

import org.springframework.context.annotation.Bean;

import container.service.DevicesService;
import container.service.UserService;

public class Configuration {

	@Bean
	public DevicesService devicesService() {

		DevicesService devicesService = new DevicesService();

		return devicesService;

	}

	@Bean
	public UserService userService() {

		UserService userService = new UserService();

		return userService;

	}

}
