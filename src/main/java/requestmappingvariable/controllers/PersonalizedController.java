package requestmappingvariable.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class PersonalizedController {

	private String name;
	
	public PersonalizedController(String name) {
		this.name = name;
	}
	
	public ResponseEntity<Object> makePetition(String method,Object body) {
		// TODO Auto-generated method stub
		switch (method) {
		case "GET":
			return doGet(body);
		case "POST":
			return doPost(body);
		case "PUT":
			return doPut(body);
		case "DELETE":
			return doDelete(body);
		default:
			return new ResponseEntity<Object>("",HttpStatus.METHOD_NOT_ALLOWED);
		}
	}
	
	public ResponseEntity<Object> doGet(Object body) {
		return new ResponseEntity<Object>("["+name+"] GET",HttpStatus.NOT_IMPLEMENTED);
	}
	
	public ResponseEntity<Object> doPost(Object body) {
		return new ResponseEntity<Object>("["+name+"] POST",HttpStatus.NOT_IMPLEMENTED);
	}
	
	public ResponseEntity<Object> doDelete(Object body) {
		return new ResponseEntity<Object>("["+name+"] DELETE",HttpStatus.NOT_IMPLEMENTED);
	}
	
	public ResponseEntity<Object> doPut(Object body) {
		return new ResponseEntity<Object>("["+name+"] PUT",HttpStatus.NOT_IMPLEMENTED);
	}

}
