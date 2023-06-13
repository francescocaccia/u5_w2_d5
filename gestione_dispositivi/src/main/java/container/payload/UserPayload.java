package container.payload;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class UserPayload {
	@NotBlank
	private String username;
	private String name;
	private String surname;
	private String email;

}
