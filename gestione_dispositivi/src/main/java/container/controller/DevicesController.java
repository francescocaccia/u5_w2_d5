package container.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

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

import container.entity.Devices;
import container.exception.UserAlreadyPresentException;
import container.payload.DevicePayload;
import container.service.DevicesService;

@RestController
@RequestMapping("/devices")
public class DevicesController {

	@Autowired
	DevicesService devicesService;

	@GetMapping("/list")
	public ResponseEntity<List<Devices>> getDevice() {

		List<Devices> device = devicesService.listDevices();
		return new ResponseEntity<>(device, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Devices> getUser(@RequestParam UUID id) {

		Optional<Devices> device1 = devicesService.getById(id);

		if (device1.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(device1.get(), HttpStatus.OK);

	}

	@PostMapping("/addDevice")
	public ResponseEntity<Devices> addDevice(@RequestBody DevicePayload devicePayload) {

		try {
			devicesService.addDevices(devicePayload);
			return new ResponseEntity("device aggiunto correttamente", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity("impossibile aggiunge il device", HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity deleteDevice(@RequestParam UUID id) {

		devicesService.deleteDevice(id);
		return new ResponseEntity<>("device eliminato correttamente", HttpStatus.OK);
	}

	@PutMapping("/put/{id}")
	public ResponseEntity<Devices> putDevice(@RequestBody DevicePayload devicePayload) {

		try {
			devicesService.putDevices(devicePayload, null);
			return new ResponseEntity("device aggiornato correttamente", HttpStatus.OK);
		} catch (UserAlreadyPresentException myException) {
			return new ResponseEntity("impossibile modificare il device", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
