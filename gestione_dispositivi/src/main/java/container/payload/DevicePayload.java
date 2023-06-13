package payload;

import javax.validation.constraints.NotNull;

import entity.enums.Status;
import entity.enums.Type;
import lombok.Data;

//corrisponde al body di una richiesta http

@Data
public class DevicePayload {

	@NotNull
	private Type type;
	@NotNull
	private Status status;

}
