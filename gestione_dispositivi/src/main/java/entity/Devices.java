package entity;

import java.util.UUID;

import org.springframework.data.annotation.Id;

import entity.enums.Status;
import entity.enums.Type;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
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
	UUID id;

}
