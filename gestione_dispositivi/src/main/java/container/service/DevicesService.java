package container.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import container.entity.Devices;
import container.payload.DevicePayload;
import container.repository.DevicesRepository;

public class DevicesService {

	@Autowired
	private DevicesRepository devicesRepository;

	public List<Devices> listDevices() {

		return devicesRepository.findAll();
	}

	public Optional<Devices> getById(UUID id) {

		return devicesRepository.findById(id);
	}

	public void deleteDevice(UUID id) {

		devicesRepository.deleteById(id);
	}

	public void addDevices(DevicePayload devicesPayload) throws Exception {

		Devices device = new Devices();

		device.setStatus(devicesPayload.getStatus());
		device.setType(devicesPayload.getType());
		devicesRepository.save(device);

	}

	public void putDevices(DevicePayload devicesPayload, UUID id) {

		Optional<Devices> device = getById(id);

		if (device.isPresent()) {

			Devices devices1 = device.get();

			devices1.setStatus(devicesPayload.getStatus());
			devices1.setType(devicesPayload.getType());

			devicesRepository.save(devices1);
		}

	}

}
