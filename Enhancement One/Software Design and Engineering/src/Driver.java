//TODO: Replace ArrayLists with SQLite storage
import java.util.Scanner;
// main driver class to manage input, user interaction, and rescue animal lists
public class Driver {
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		AnimalManager animalManager = new AnimalManager();
		boolean exit = false;

		// loop for menu display and user input to exit
		while (!exit) {
			displayMenu();
			char option = input.next().charAt(0);
			if (option == '1') {
				animalManager.intakeNewDog(input);
			} else if (option == '2') {
				animalManager.intakeNewMonkey(input);
			} else if (option == '3') {
				MatchService.reserveAnimal(input, animalManager);
			} else if (option == '4') {
				MatchService.printAnimals("dog", animalManager);
			} else if (option == '5') {
				MatchService.printAnimals("monkey", animalManager);
			} else if (option == '6') {
				MatchService.printAnimals("available", animalManager);
			} else if (option == 'q') {
				System.out.println("Exiting the program. Goodbye!");
				exit = true;
			} else {
				System.out.println("please enter valid input");
			}
		}
	}
// display the main user menu
	public static void displayMenu() {
		System.out.println("\n\n");
		System.out.println("\t\t\t\tRescue Animal System Menu");
		System.out.println("[1] Intake a new dog");
		System.out.println("[2] Intake a new monkey");
		System.out.println("[3] Reserve an animal");
		System.out.println("[4] Print a list of all dogs");
		System.out.println("[5] Print a list of all monkeys");
		System.out.println("[6] Print a list of all animals that are not reserved");
		System.out.println("[q] Quit application");
		System.out.println();
		System.out.println("Enter a menu selection");
}
}
