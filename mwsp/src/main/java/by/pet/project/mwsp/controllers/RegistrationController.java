package by.pet.project.mwsp.controllers;

import by.pet.project.mwsp.dtos.ClientInfoCreateDto;
import by.pet.project.mwsp.services.RegistrationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
@RequiredArgsConstructor
public class RegistrationController {

	private final RegistrationService registrationService;

	@PostMapping("/registration")
	@PreAuthorize("permitAll()")
	public ResponseEntity<Void> registration(@RequestBody ClientInfoCreateDto clientInfoCreateDto) {
		log.info("registration: clientInfo = {}", clientInfoCreateDto);

		ClientInfoCreateDto responseMessage = registrationService.registration(clientInfoCreateDto);
		return ResponseEntity.status(HttpStatus.OK).build();
	}

}
