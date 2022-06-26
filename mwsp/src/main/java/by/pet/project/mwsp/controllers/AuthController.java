package by.pet.project.mwsp.controllers;

import by.pet.project.mwsp.services.AuthService;
import by.pet.project.mwsp.services.api.LoginResponseMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

@RestController
@RequiredArgsConstructor
public class AuthController {

	private final AuthService authService;

	@PostMapping("/auth/login")
	@PreAuthorize("permitAll()")
	public ResponseEntity<LoginResponseMessage> login(@RequestParam @NotNull String email,
			@RequestParam @NotNull String pass) {
		LoginResponseMessage responseMessage = authService.login(email, pass);
		return ResponseEntity.status(HttpStatus.OK).body(responseMessage);
	}

	@PostMapping("/auth/tokenRefresh")
	@PreAuthorize("permitAll()")
	public ResponseEntity<LoginResponseMessage> tokenRefresh(@RequestParam String refreshToken) throws Exception {
		var responseMessage = authService.tokenRefresh(refreshToken);
		return ResponseEntity.status(HttpStatus.OK).body(responseMessage);
	}

}