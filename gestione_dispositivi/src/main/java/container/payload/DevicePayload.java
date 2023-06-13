package container.payload;

import javax.validation.constraints.NotNull;

import container.entity.enums.Status;
import container.entity.enums.Type;
import lombok.Data;

//corrisponde al body di una richiesta http

@Data
public class DevicePayload {

	@NotNull
	private Type type;
	@NotNull
	private Status status;

}
