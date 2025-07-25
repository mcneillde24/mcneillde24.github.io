import java.util.Scanner;

public class MatchService {
//Method to reserve animal
	public static void reserveAnimal(Scanner scanner, AnimalManager animalManager) {
		scanner.nextLine();

		System.out.println("Enter animal type (Dog or Monkey): ");
		String type = scanner.nextLine().trim();
		
		if (!type.equalsIgnoreCase("dog") && !type.equalsIgnoreCase("monkey")) {
			System.out.println("Invalid input");
			return;
		}
		System.out.println("Enter animal service country: ");
		String serviceCountry = scanner.nextLine().trim();

		if (type.equalsIgnoreCase("dog")) {
			for (Dog dog : animalManager.getDogList()) {
            if (dog.getInServiceCountry().equalsIgnoreCase(serviceCountry) && !dog.getReserved()) {
                dog.setReserved(true);
                System.out.println(dog.getName() + " is now reserved.");
                return;
				}
			}
		} else {
			for (Monkey monkey : animalManager.getMonkeyList()) {
            if (monkey.getInServiceCountry().equalsIgnoreCase(serviceCountry) && !monkey.getReserved()) {
                monkey.setReserved(true); // Update the reservation status
                System.out.println(monkey.getName() + " is now reserved.");
                return;
				}
			}
		}
        //message if no matching animal is found
        System.out.println("No available " + type + " found in service country: " + serviceCountry); 
}

// Method to print and display information about the animal including in service or reserved
	public static void printAnimals(String type, AnimalManager animalManager) {
		if (type.equalsIgnoreCase("dog")) {
			System.out.println("List of dogs: ");
			for (Dog dog : animalManager.getDogList()) {
				System.out.println(dog.getName() + "\t" + dog.getTrainingStatus() + "\t" + dog.getAcquisitionLocation()
				+ "\t" + dog.getReserved());
			}
		} else if (type.equalsIgnoreCase("monkey")) {
			System.out.println("List of monkeys: ");
			for (Monkey monkey : animalManager.getMonkeyList()) {
				System.out.println(monkey.getName() + "\t" + monkey.getTrainingStatus() + "\t"
						+ monkey.getAcquisitionLocation() + "\t" + monkey.getReserved());
			}
		} else if (type.equalsIgnoreCase("available")) {
			System.out.println("List of available animals: ");
			for (Dog dog : animalManager.getDogList()) {
				if (dog.getTrainingStatus().equalsIgnoreCase("in service") && !dog.getReserved()) {
					System.out.println(dog.getName() + "\t" + dog.getTrainingStatus() + "\t"
							+ dog.getAcquisitionLocation() + "\t" + dog.getReserved());
				}
			}
			for (Monkey monkey : animalManager.getMonkeyList()) {
				if (monkey.getTrainingStatus().equalsIgnoreCase("in service") && !monkey.getReserved()) {
					System.out.println(monkey.getName() + "\t" + monkey.getTrainingStatus() + "\t"
							+ monkey.getAcquisitionLocation() + "\t" + monkey.getReserved());
				}
			}
		} else {
            System.out.println("Invalid animal type. Please enter 'dog', 'monkey', or 'available'.");
        }
	}
}
