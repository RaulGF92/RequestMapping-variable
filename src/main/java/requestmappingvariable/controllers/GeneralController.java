package requestmappingvariable.controllers;
import java.net.URI;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.support.ManagedArray;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import requestmappingvariable.PathPetitions;

@RestController
public class GeneralController {

	PathPetitions petitions = PathPetitions.getInstance();
	
    @RequestMapping(value = "**", method = RequestMethod.GET)
    public ResponseEntity<Object> get(HttpServletRequest request,HttpServletResponse response) {
    	return handlePetition(request,response,null);
    }
    
    @RequestMapping(value = "**", method = RequestMethod.POST)
    public ResponseEntity<Object> post(HttpServletRequest request,HttpServletResponse response,@RequestBody Object body) {
    	return handlePetition(request,response,body);
    }
    
    @RequestMapping(value = "**", method = RequestMethod.PUT)
    public ResponseEntity<Object> put(HttpServletRequest request,HttpServletResponse response,@RequestBody Object body) {
    	return handlePetition(request,response,body);
    }
    
    @RequestMapping(value = "**", method = RequestMethod.DELETE)
    public ResponseEntity<Object> delete(HttpServletRequest request,HttpServletResponse response,@RequestBody Object body) {
    	return handlePetition(request,response,body);
    }
    
    @RequestMapping(value = "**", method = RequestMethod.HEAD)
    public ResponseEntity<Object> head(HttpServletRequest request,HttpServletResponse response) {
    	return handlePetition(request,response,null);
    }
    
    @RequestMapping(value = "**", method = RequestMethod.TRACE)
    public ResponseEntity<Object> trace(HttpServletRequest request,HttpServletResponse response) {
    	return handlePetition(request,response,null);
    }
    
    @RequestMapping(value = "**", method = RequestMethod.OPTIONS)
    public ResponseEntity<Object> options(HttpServletRequest request,HttpServletResponse response,@RequestBody Object body) {
    	return handlePetition(request,response,body);
    }
    
	private ResponseEntity<Object> handlePetition(HttpServletRequest request, HttpServletResponse response,Object body) {
		// TODO Auto-generated method stub
		String petition = request.getRequestURI();
		String method = request.getMethod();
		
		PersonalizedController controller = petitions.getController(petition);
		
		if(controller == null)
			return new ResponseEntity<Object>("",HttpStatus.NOT_FOUND);
		
		return controller.makePetition(method,body);
	}
}