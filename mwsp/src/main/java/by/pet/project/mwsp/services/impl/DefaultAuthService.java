package by.pet.project.mwsp.services.impl;

import by.pet.project.mwsp.services.AuthService;
import by.pet.project.mwsp.services.api.LoginResponseMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.keycloak.authorization.client.AuthzClient;
import org.keycloak.authorization.client.util.Http;
import org.keycloak.representations.AccessTokenResponse;
import org.springframework.stereotype.Service;

@Log4j2
@Service
@RequiredArgsConstructor
public class DefaultAuthService implements AuthService {

	private final AuthzClient authzClient;

	public LoginResponseMessage login(String email, String pass) {
		log.info("login: email = {} start", email);

		var response = authzClient.authorization(email, pass).authorize();
		LoginResponseMessage responseMessage = LoginResponseMessage.builder()
				.tokenType(response.getTokenType())
				.token(response.getToken())
				.refreshToken(response.getRefreshToken())
				.build();

		log.info("login: email = {} finished", email);
		return responseMessage;
	}

	@Override
	public LoginResponseMessage tokenRefresh(String refresh) {
		log.info("tokenRefresh: start");

		String url = authzClient.getConfiguration().getAuthServerUrl() + "/realms/" +
				authzClient.getConfiguration().getRealm() + "/protocol/openid-connect/token";
		String clientId = authzClient.getConfiguration().getResource();
		String secret = (String) authzClient.getConfiguration().getCredentials().get("secret");
		var http = new Http(authzClient.getConfiguration(), (params, headers) -> {
		});

		var response = http.<AccessTokenResponse>post(url)
				.authentication()
				.client()
				.form()
				.param("grant_type", "refresh_token")
				.param("refresh_token", refresh)
				.param("client_id", clientId)
				.param("client_secret", secret)
				.response()
				.json(AccessTokenResponse.class)
				.execute();

		LoginResponseMessage result = LoginResponseMessage.builder()
				.tokenType(response.getTokenType())
				.token(response.getToken())
				.refreshToken(response.getRefreshToken())
				.build();

		log.info("tokenRefresh: finished");
		return result;
	}

}
