package preparation.designpatterns.creational;

/**
 * The Factory Method pattern is a way to make things without saying exactly
 * what kind of thing to make. It makes an outline for making things but let's
 * different kinds of things choose what kind of thing to make. This is helpful
 * when you want to make things without worrying about how they are made.
 * 
 * To implement the Factory Pattern, we will need to:
 * 
 * Define an interface or abstract class that declares the factory method for
 * creating objects. Create concrete classes that implement the interface or
 * abstract class and provide their own implementation of the factory method.
 * Define a client class that uses the factory method to create objects without
 * knowing their exact class.
 * 
 * Use Factory Pattern:
	When you need to create objects of a single type or hierarchy.
	When the creation logic is simple and doesn’t involve multiple related objects.
	Example: Creating different types of notifications (email, SMS) based on user input.

 */
public class FactoryMethodDesignPattern {

	public static void main(String[] args) {
		System.out.println("GetPlan.getPlan(\"DOMESTIC\") : "+GetPlan.getPlan("DOMESTIC"));
		GetPlan.getPlan("International");
	}

}

abstract class Plan {
	abstract double getRate();
}

class DomesticPlan extends Plan {
	double getRate() {
		return 3.5;
	}
}

class GetPlan {
	static Plan getPlan(String type) {
		return switch (type) {
		case "DOMESTIC" -> new DomesticPlan();
		default -> throw new IllegalArgumentException();
		};
	}
}