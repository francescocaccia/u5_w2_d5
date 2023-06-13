package entity;

import java.util.UUID;

import org.springframework.data.annotation.Id;

import entity.enums.Status;
import entity.enums.Type;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
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
	UUID id;

	public void setType(Type type) {

		this.type = type;

	}

	public void setStatus(Status status) {

		this.status = status;

	}

	public Status getStatus() {

		return status;

	}

	public Type getType() {

		return type;
	}

}
