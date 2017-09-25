package requestmappingvariable;

import java.net.URI;
import java.util.HashMap;

import requestmappingvariable.controllers.PersonalizedController;

public class PathPetitions {

	HashMap<String, PersonalizedController> petitions;
	private static PathPetitions singleton = null;

	public static PathPetitions getInstance() {
		if (singleton != null)
			return singleton;
		singleton = new PathPetitions();
		return singleton;
	}

	private PathPetitions() {
		petitions = new HashMap<String, PersonalizedController>();
		
		// Inicialization zone - this zone don't must exist
			petitions.put("/wot/thing/esta1", new PersonalizedController("esta1"));
			petitions.put("/wot/thing/esta2", new PersonalizedController("esta2"));
		// -------------------------------------------------

	}

	public void addNewController(URI uri, PersonalizedController controller) {
		petitions.put(uri.getPath(), controller);
	}

	public void removeController(URI uri) {
		petitions.remove(uri.getPath());
	}
	
	public PersonalizedController getController(String key) {
		return this.petitions.get(key);
	}
}
