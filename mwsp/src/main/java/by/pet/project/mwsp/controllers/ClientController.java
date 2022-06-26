package by.pet.project.mwsp.controllers;

import by.pet.project.mwsp.dtos.ClientInfoDto;
import by.pet.project.mwsp.services.ClientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Log4j2
public class ClientController {

	private final ClientService clientService;

	@GetMapping("/client/{clientId}")
	@PreAuthorize("hasRole('USER')")
	public ResponseEntity<ClientInfoDto> getClientInfoById(@PathVariable String clientId) {
		//		var result = clientService.getClientById(clientId);
		log.info("client id {}", clientId);
		return ResponseEntity.status(HttpStatus.OK).body(new ClientInfoDto());
	}

	@GetMapping("/client")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<List<ClientInfoDto>> getAllClients() {
		log.info("getAllClients: ");
		List<ClientInfoDto> allClients = clientService.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(allClients);
	}

}
