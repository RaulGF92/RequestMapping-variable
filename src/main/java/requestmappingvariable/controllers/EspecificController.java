package requestmappingvariable.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EspecificController {

	@RequestMapping("/dir")
	public String wot() {
		return "dir";
	}
}
