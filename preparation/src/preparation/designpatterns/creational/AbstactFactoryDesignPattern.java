package preparation.designpatterns.creational;

/**
 * The Abstract Factory Pattern is a creational design pattern that provides an interface for creating families of related or dependent objects without specifying their concrete classes. It’s essentially a factory of factories, allowing the creation of different product families.

Key Components
Abstract Factory: An interface or abstract class declaring methods for creating abstract products.
Concrete Factory: Classes that implement the Abstract Factory to create specific product families.
Abstract Product: Interfaces for a family of related products.
Concrete Product: Classes implementing the Abstract Product interfaces.
 * 
 * 
 * When to Use Abstract Factory Pattern:
	When you need to create families of related objects that must work together.
	When you want to ensure consistency across objects (e.g., all UI components for a specific platform).
	Example: Creating platform-specific UI kits or game asset families.
 */
public class AbstactFactoryDesignPattern {

	public static void main(String[] args) {
		// Create Windows UI
		UIFactory windowsFactory = new WindowsUIFactory();
		Button windowsButton = windowsFactory.createButton();
		Checkbox windowsCheckbox = windowsFactory.createCheckbox();
		windowsButton.render(); // Output: Rendering Windows Button
		windowsCheckbox.check(); // Output: Checking Windows Checkbox

		// Create Mac UI
		UIFactory macFactory = new MacUIFactory();
		Button macButton = macFactory.createButton();
		Checkbox macCheckbox = macFactory.createCheckbox();
		macButton.render(); // Output: Rendering Mac Button
		macCheckbox.check(); // Output: Checking Mac Checkbox
	}

}

//Abstract Products
interface Button {
	void render();
}

interface Checkbox {
	void check();
}

//Concrete Products for Windows
class WindowsButton implements Button {
	public void render() {
		System.out.println("Rendering Windows Button");
	}
}

class WindowsCheckbox implements Checkbox {
	public void check() {
		System.out.println("Checking Windows Checkbox");
	}
}

//Concrete Products for Mac
class MacButton implements Button {
	public void render() {
		System.out.println("Rendering Mac Button");
	}
}

class MacCheckbox implements Checkbox {
	public void check() {
		System.out.println("Checking Mac Checkbox");
	}
}

//Abstract Factory
interface UIFactory {
	Button createButton();

	Checkbox createCheckbox();
}

//Concrete Factories
class WindowsUIFactory implements UIFactory {
	public Button createButton() {
		return new WindowsButton();
	}

	public Checkbox createCheckbox() {
		return new WindowsCheckbox();
	}
}

class MacUIFactory implements UIFactory {
	public Button createButton() {
		return new MacButton();
	}

	public Checkbox createCheckbox() {
		return new MacCheckbox();
	}
}
