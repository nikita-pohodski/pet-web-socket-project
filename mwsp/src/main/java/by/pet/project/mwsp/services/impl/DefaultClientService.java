package by.pet.project.mwsp.services.impl;

import by.pet.project.mwsp.dtos.ClientInfoDto;
import by.pet.project.mwsp.services.ClientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
@RequiredArgsConstructor
public class DefaultClientService implements ClientService {

	private final Keycloak keycloak;

	@Override
	public List<ClientInfoDto> findAll() {
		List<UserRepresentation> userRepresentations = keycloak.realm("chat").users().list();

		return userRepresentations.stream()
				.map(userRepresentation -> ClientInfoDto.builder()
						.firstname(userRepresentation.getFirstName())
						.lastname(userRepresentation.getLastName())
						.email(userRepresentation.getUsername())
						.build())
				.toList();
	}

}
