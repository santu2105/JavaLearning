package preparation.designpatterns.creational;

/**
 * The singleton design pattern is a way to make sure that only one copy of a class exists. It is used when we want to have a global way to access this class. We use the singleton pattern when we need one object to control things in the whole system.

	To implement the Singleton Pattern, we will need to:

	Define a class with a private constructor, so that no other class can instantiate it.
	Declare a static variable of the same type as the class and create an instance of the class in the variable.
	Declare a static method that returns the instance of the class.
 */
public class SingletonDesignPattern {

	public static void main(String[] args) {
		System.out.println("Singleton.getInstance() address: "+Singleton.getInstance());
		System.out.println("Singleton.getInstance() address: "+Singleton.getInstance());
		
		System.out.println("StudentService.getInstance() address: "+StudentService.getInstance());
		System.out.println("StudentService.getInstance() address: "+StudentService.getInstance());

	}
}

class Singleton {
    private static Singleton instance = null;

    private Singleton() {
        // private constructor
    }

    public static synchronized Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}


class StudentService{
	private static StudentService service= null;
	
	private StudentService() {
		//Private constructor, and default one
	}
	public static synchronized StudentService getInstance() {
		if (service==null) {
			service = new StudentService();
		}
		return service;
	}
}
