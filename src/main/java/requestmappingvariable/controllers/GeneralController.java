package requestmappingvariable.controllers;
import java.net.URI;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.support.ManagedArray;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import requestmappingvariable.PathPetitions;

@RestController
public class GeneralController {

	PathPetitions petitions = PathPetitions.getInstance();
	
    @RequestMapping("**")
    public ResponseEntity<Object> index(HttpServletRequest request,HttpServletResponse response,@RequestBody Object body) {
    	return handlePetition(request,response);
    }

	private ResponseEntity<Object> handlePetition(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String petition = request.getRequestURI();
		String method = request.getMethod();
		
		return petitions.getController(petition).makePetition(method,new String());
	}
}