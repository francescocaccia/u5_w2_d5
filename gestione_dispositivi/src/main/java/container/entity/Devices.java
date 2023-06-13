package container.entity;

import org.springframework.data.annotation.Id;

import container.entity.enums.Status;
import container.entity.enums.Type;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table
public class Devices {

	@Column
	@Enumerated(EnumType.STRING)
	Type type;
	@Column
	@Enumerated(EnumType.STRING)
	Status status;
	@Id
	@GeneratedValue
	int id;

}
