package by.pet.project.mwsp.services.api;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class LoginResponseMessage {

	private String token;
	private String refreshToken;
	private String tokenType;

}
