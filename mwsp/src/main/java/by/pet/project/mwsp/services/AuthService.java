package by.pet.project.mwsp.services;

import by.pet.project.mwsp.services.api.LoginResponseMessage;

public interface AuthService {

	LoginResponseMessage login(String email, String pass);

	LoginResponseMessage tokenRefresh(String refreshToken) throws Exception;

}
