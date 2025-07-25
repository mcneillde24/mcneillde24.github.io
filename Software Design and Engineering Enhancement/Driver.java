import java.util.ArrayList;
import java.util.Scanner;
//set public class
public class Driver {
	//create array to store data for dog and monkey
	private static ArrayList<Dog> dogList = new ArrayList<Dog>();
	private static ArrayList<Monkey> monkeyList = new ArrayList<Monkey>();
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		boolean exit = false;
		
		initializeDogList();
		initializeMonkeyList();

		//loop for menu display and user input to exit
		while (!exit) {
			displayMenu();
			char option = input.next().charAt(0);
			if (option == '1') {
				intakeNewDog(input);
			} else if (option == '2') {
				intakeNewMonkey(input);
			} else if (option == '3') {
				reserveAnimal(input);
			} else if (option == '4') {
				printAnimals("dog");
			} else if (option == '5') {
				printAnimals("monkey");
			} else if (option == '6') {
				printAnimals("available");
			} else if (option == 'q') {
				exit = true;
			} else {
				System.out.println("please enter valid input");
			}
		}
	}
//menu display
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
// initialize dogList Method
public static void initializeDogList() {
Dog dog1 = new Dog("Dex", "German Shepherd", "male", "1", "25.6", "05-12-2023", "United States", "intake",
false, "United States");
Dog dog2 = new Dog("Goof", "Great Dane", "male", "3", "35.2", "02-03-2021", "United States", "Phase I", false,
"United States");
Dog dog3 = new Dog("Daisy", "Chihuahua", "female", "4", "25.6", "12-12-2020", "Canada", "in service", true,
"Canada");
dogList.add(dog1);
dogList.add(dog2);
dogList.add(dog3);
}

//Intake NewDog Method
	public static void intakeNewDog(Scanner scanner) {
		System.out.println("What is the dog's name?");
		String name = scanner.next();
		for (Dog dog : dogList) {
			if (dog.getName().equalsIgnoreCase(name)) {
				System.out.println("\n\nThis dog is already in the system\n\n");
				return;
			}
}
		// Add new dog and add to list
		System.out.println("What is the dog's breed?");
		String breed = scanner.next();
		System.out.println("What is the dog's gender?");
		String gender = scanner.next();
		System.out.println("What is the dog's age?");
		String age = scanner.next();
		System.out.println("What is the dog's weight?");
		String weight = scanner.next();
		System.out.println("What is the dog's acquisition date? [mm/dd/yy]");
		String acDate = scanner.next();
		System.out.println("What is the dog's acquisition country?");
		String acCountry = scanner.next();
		System.out.println("What is the dog's training status?");
		String trainingStatus = scanner.next();
		System.out.println("Is the dog reserved? [true or false]");
		boolean reserve = scanner.nextBoolean();
		System.out.println("What is the dog's service country?");
		String serviceCountry = scanner.next();
		dogList.add(new Dog(name, breed, gender, age, weight, acDate, acCountry,
				trainingStatus, reserve, serviceCountry));
}
	
// initialize monkeyList Method
public static void initializeMonkeyList() {
Monkey monkey1 = new Monkey("Macy", "female", "1", "15.6", "05-05-2023", "United States", "in service", true, "United States", 42, 10, 32, "capuchin");
Monkey monkey2 = new Monkey("Lulu", "female", "2", "14.7", "06-07-2022", "United States", "Phase I", false, "United Kingdom", 35, 9, 29, "tamarin");
Monkey monkey3 = new Monkey("Julian", "male", "1", "16.0", "09-01-2023", "Canada", "in service", true, "Colombia", 43, 11, 30, "squirrel monkey");
monkeyList.add(monkey1);
monkeyList.add(monkey2);
monkeyList.add(monkey3);
	}
//Intake NewMonkey method
	public static void intakeNewMonkey(Scanner scanner) {
		boolean quit = false;
		while (!quit) {
			System.out.println("What is the monkey's name?\n"
					+ "Enter \"q\" now to exit");
			String name = scanner.next();
			if (name.equals("q")) {quit = true; break;}
			for (Monkey monkey : monkeyList) {
				if (monkey.getName().equalsIgnoreCase(name)) {
					System.out.println("\n\nThis monkey is already in our system\n\n");
					return;
				}
}
//Get input from user, including monkey's species
			System.out.println("What is the monkey's species?");
			System.out.println(" Valid species include the following:\n"
					+ " capuchin | guenon | macaque\n "
					+ " marmoset | squirrel monkey | tamarin");
			String species = scanner.next().toLowerCase();
//validates input of monkey species, and matches to available species
			if (!species.equals("capuchin") && !species.equals("guenon") && !species.equals("macaque")
					&& !species.equals("marmoset") && !species.equals("squirrel monkey") && !species.equals("tamarin")) {
				System.out.println("\n\nThis monkey is not eligible for training\n\n");
				return;
		}
			//add new monkey and add to list
			System.out.println("What is the monkey's gender?");
			String gender = scanner.next();
			System.out.println("What is the monkey's age?");
			String age = scanner.next();
			System.out.println("What is the monkey's weight?");
			String weight = scanner.next();
			System.out.println("What is the monkey's acquisition date? [mm/dd/yy]");
			String acDate = scanner.next();
			System.out.println("What is the monkey's acquisition country?");
			String acCountry = scanner.next();
			System.out.println("What is the monkey's training status?");
			String trainingStatus = scanner.next();
			System.out.println("Is the monkey reserved? [true or false]");
			boolean reserve = scanner.nextBoolean();
			System.out.println("What is the monkey's service country?");
			String serviceCountry = scanner.next();
			System.out.println("What is the monkey's body length?");
			int bodyLength = scanner.nextInt();
			System.out.println("What is the monkey's tail length?");
			int tailLength = scanner.nextInt();
			System.out.println("What is the monkey's height?");
			int height = scanner.nextInt();
			
			//confirms that user wants to add monkey to list or not
			System.out.println("Would you like to save this information and add this new monkey?");
			String addInput = scanner.next();
			
			while (!(addInput == null)) {
				if ((addInput.equalsIgnoreCase("yes"))|| (addInput.equalsIgnoreCase("y"))) {
					monkeyList.add(new Monkey(name, gender, age, weight, acDate, acCountry, trainingStatus, reserve,serviceCountry, bodyLength, tailLength, height, species));
					break;
				} else if ((addInput.equalsIgnoreCase("no"))|| (addInput.equalsIgnoreCase("n"))) {
					break;
				} else {
					System.out.println("Please enter valid input [yes, y, no, n]");
					addInput = scanner.next();
					continue;
				}
			} break;
		}
}
//Method to reserve animal
	public static void reserveAnimal(Scanner scanner) {
		System.out.println("Enter animal type: [Dog or Monkey]");
		String type = scanner.next().toLowerCase();
		if (!type.equals("dog") && !type.equals("monkey")) {
			System.out.println("Invalid input");
			return;
		}
		System.out.println("Enter animal service country: ");
		String serviceCountry = scanner.next().toLowerCase(); //
		if (type.equals("dog")) {
			for (int i = 0; i < dogList.size(); i++) {
				if (dogList.get(i).getInServiceCountry().equals(serviceCountry) && !dogList.get(i).getReserved()) {
					System.out.println(dogList.get(i).toString() + " is now reserved.");
					return;
				}
			}
		} else {
			for (int i = 0; i < monkeyList.size(); i++) {
				if (monkeyList.get(i).getInServiceCountry().equals(serviceCountry)
						&& !monkeyList.get(i).getReserved()) {
					System.out.println(monkeyList.get(i).getName() + " is now reserved.");
					return;
				}
			}
		}
}
// Method to print and display information about the animal including in service or reserved
	public static void printAnimals(String type) {
		if (type.toLowerCase().equals("dog")) {
			System.out.println("List of dogs: ");
			for (Dog dog : dogList) {
				System.out.println(dog.getName() + "\t" + dog.getTrainingStatus() + "\t" + dog.getAcquisitionLocation()
				+ "\t" + dog.getReserved());
			}
		} else if (type.toLowerCase().equals("monkey")) {
			System.out.println("List of dogs: ");
			for (Monkey monkey : monkeyList) {
				System.out.println(monkey.getName() + "\t" + monkey.getTrainingStatus() + "\t"
						+ monkey.getAcquisitionLocation() + "\t" + monkey.getReserved());
			}
		} else if (type.toLowerCase().equals("available")) {
			System.out.println("List of available animals: ");
			for (Dog dog : dogList) {
				if (dog.getTrainingStatus().equalsIgnoreCase("in service") && !dog.getReserved()) {
					System.out.println(dog.getName() + "\t" + dog.getTrainingStatus() + "\t"
							+ dog.getAcquisitionLocation() + "\t" + dog.getReserved());
				}
			}
			for (Monkey monkey : monkeyList) {
				if (monkey.getTrainingStatus().equalsIgnoreCase("in service") && !monkey.getReserved()) {
					System.out.println(monkey.getName() + "\t" + monkey.getTrainingStatus() + "\t"
							+ monkey.getAcquisitionLocation() + "\t" + monkey.getReserved());
				}
			}
		}
	}
}
