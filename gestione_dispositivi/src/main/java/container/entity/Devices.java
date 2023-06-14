package container.entity;

import java.io.Serializable;

import container.entity.enums.Status;
import container.entity.enums.Type;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "devices")

public class Devices implements Serializable {

	@Id
	@GeneratedValue
	int id;
	@Column
	@Enumerated(EnumType.STRING)
	Type type;
	@Column
	@Enumerated(EnumType.STRING)
	Status status;

}
