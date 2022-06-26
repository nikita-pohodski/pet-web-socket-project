package by.pet.project.mwsp.controllers;

import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@Log4j2
public class DefaultHomePageController {

	@GetMapping("home")
	public ResponseEntity<String> getHomePage() {
		log.info("getHomePage: ");
		return ResponseEntity.ok("This is home page");
	}

	@GetMapping()
	public RedirectView redirectToHomePage() {
		log.info("redirectToHomePage: ");
		return new RedirectView("/home");
	}

}
