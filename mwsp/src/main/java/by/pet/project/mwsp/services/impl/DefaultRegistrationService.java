package by.pet.project.mwsp.services.impl;

import by.pet.project.mwsp.dtos.ClientInfoCreateDto;
import by.pet.project.mwsp.services.RegistrationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.stereotype.Service;

import javax.ws.rs.core.Response;
import java.util.List;

@Service
@Log4j2
@RequiredArgsConstructor
public class DefaultRegistrationService implements RegistrationService {

	private final Keycloak keycloak;

	@Override
	public ClientInfoCreateDto registration(ClientInfoCreateDto createDto) {
		CredentialRepresentation credentialRepresentation = new CredentialRepresentation();
		credentialRepresentation.setType(CredentialRepresentation.PASSWORD);
		credentialRepresentation.setValue(createDto.getPassword());

		UserRepresentation userRepresentation = new UserRepresentation();
		userRepresentation.setUsername(createDto.getEmail());
		userRepresentation.setCredentials(List.of(credentialRepresentation));
		userRepresentation.setFirstName(createDto.getFirstname());
		userRepresentation.setLastName(createDto.getLastname());
		userRepresentation.setEmail(createDto.getEmail());
		userRepresentation.setEnabled(true);
		userRepresentation.setEmailVerified(true);
		userRepresentation.setGroups(List.of("USERS"));

		Response response = keycloak.realm("chat").users().create(userRepresentation);

		log.info(response.getStatus());
		return null;
	}

}
