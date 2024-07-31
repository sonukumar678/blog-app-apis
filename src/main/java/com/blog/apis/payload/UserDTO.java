package com.blog.apis.payload;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDTO {
	
	private int id;
	
	@NotEmpty
	@Size(min = 4, message = "Username must be minimum 4 char")
	private String name;
	
	@NotEmpty
	@Email(message = "Email address is not valid")
	private String email;
	
	@NotEmpty
	@Size(min = 3, max = 10, message = "password must be contains min to max chars")
	private String password;
	
	@NotEmpty
	private String about;

	
}
