# RequestMapping-variable
A way to make REST controller on java mapping by a variable in execution time. 

# Add a new Mapping
Have two ways to add new controllers. First way adding new mapping in inicialization site in PathPetitions (this way is not recomended but is a way to test the app). 

		// Inicialization zone - this zone don't must exist
			petitions.put("/wot/thing/esta1", new PersonalizedController("esta1"));
			petitions.put("/wot/thing/esta2", new PersonalizedController("esta2"));
		// -------------------------------------------------
 
 The second way is created a instace of PathPettions and then addNewController. This way is in compile time and provide you a new Http mapping in the URI selected.
    
    PathPetitions petitions = PathPetitions.getInstance();
    petitions.addNewController(new URI("/mydir"), new PersonalizedController("esta1"));

# Implement your controllers
Two implement your controllers you must created a new class that inherit of PersonalizedControllers. This class managed all http methods. All you do is override http methods and the father class managed for you.

        public MyController extends PersonalizedController {
        
a example of a override method, in the case that your class don't implement a method the father method send to client a **NOT_IMPLEMENT** status.

        @overide
        public ResponseEntity<Object> doGet(Object body){
          // Do my stuff
          return new ResponseEntity<Object>("OK",HttpStatus.OK);
        }
