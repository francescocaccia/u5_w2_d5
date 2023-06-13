package container.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import container.entity.Devices;

public interface DevicesRepository extends JpaRepository<Devices, UUID> {
//i metodi li prenderà direttamente dal JpaRepository
}
