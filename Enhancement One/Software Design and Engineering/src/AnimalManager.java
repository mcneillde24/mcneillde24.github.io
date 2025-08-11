import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AnimalManager {
    // create array to store data for dog and monkey objects
    private static ArrayList<Dog> dogList = new ArrayList<Dog>();
    private static ArrayList<Monkey> monkeyList = new ArrayList<Monkey>();

    public AnimalManager() {
        // pre-load some initial animals
        initializeDogList();
        initializeMonkeyList();
    }

    public List<Dog> getDogList() {
        return dogList;
    }

    public List<Monkey> getMonkeyList() {
        return monkeyList;
    }

    // Saving an animal during intake helper method
    public static boolean confirmSave(Scanner scanner, String animalName) {
        while (true) {
            System.out.println("Would you like to save this " + animalName + "? [yes/no]");
            String input = scanner.nextLine().trim().toLowerCase();
            if (input.equals("yes") || input.equals("y")) {
                return true;
            } else if (input.equals("no") || input.equals("n")) {
                System.out.println(animalName.substring(0, 1).toUpperCase() + animalName.substring(1) + " not added.");
                return false;
            } else {
                System.out.println("Please enter 'yes' or 'no'.");
            }
        }
    }

    // training status validation helper method
    private static boolean isValidTrainingStatus(String status) {
        return status.equalsIgnoreCase("intake") ||
                status.equalsIgnoreCase("phase I") ||
                status.equalsIgnoreCase("phase II") ||
                status.equalsIgnoreCase("in service");
    }

    // check for quit 'q' helper method
    private static boolean checkQuit(String input) {
        return input.equalsIgnoreCase("q");
    }

    // initialize dogList Method
    public static void initializeDogList() {
        Dog dog1 = new Dog("Dex", "German Shepherd", "male", "1", "25.6", "05-12-2023", "United States", "intake",
                true, "United States");
        Dog dog2 = new Dog("Goof", "Great Dane", "male", "3", "35.2", "02-03-2021", "United States", "Phase I", true,
                "United States");
        Dog dog3 = new Dog("Daisy", "Chihuahua", "female", "4", "25.6", "12-12-2020", "Canada", "in service", false,
                "Canada");
        dogList.add(dog1);
        dogList.add(dog2);
        dogList.add(dog3);
    }

    // initialize monkeyList Method
    public static void initializeMonkeyList() {
        Monkey monkey1 = new Monkey("Macy", "female", "1", "15.6", "05-05-2023", "United States", "in service", true,
                "United States", 42, 10, 32, "capuchin");
        Monkey monkey2 = new Monkey("Lulu", "female", "2", "14.7", "06-07-2022", "United States", "Phase I", false,
                "United Kingdom", 35, 9, 29, "tamarin");
        Monkey monkey3 = new Monkey("Julian", "male", "1", "16.0", "09-01-2023", "Canada", "in service", true,
                "Colombia", 43, 11, 30, "squirrel monkey");
        monkeyList.add(monkey1);
        monkeyList.add(monkey2);
        monkeyList.add(monkey3);
    }

    // Intake NewDog Method with separate line validation and confirmation save
    public static void intakeNewDog(Scanner scanner) {
        scanner.nextLine(); // clear the input buffer

        // Ask for dog's name and check for duplicates
        System.out.println("What is the dog's name? (enter 'q' to quit)");
        String name = scanner.nextLine().trim();
        if (checkQuit(name)) {
            System.out.println("Intake cancelled.");
            return;
        }
        for (Dog dog : dogList) {
            if (dog.getName().equalsIgnoreCase(name)) {
                System.out.println("\n\nThis dog is already in the system\n\n");
                return;
            }
        }

        // Get dog's breed
        System.out.println("What is the dog's breed?");
        String breed = scanner.nextLine().trim();
        if (checkQuit(breed)) {
            System.out.println("Intake cancelled.");
            return;
        }
        // Get dog's gender
        System.out.println("What is the dog's gender?");
        String gender = scanner.nextLine().trim();
        if (checkQuit(gender)) {
            System.out.println("Intake cancelled.");
            return;
        }

        // Get and validate dog's age
        String age;
        while (true) {
            System.out.println("What is the dog's age? (numeric value)");
            age = scanner.nextLine().trim();
            if (checkQuit(age)) {
                System.out.println("Intake cancelled.");
                return;
            }
            if (age.matches("\\d+")) {
                break;
            } else {
                System.out.println("Invalid age. Please enter a number.");
            }
        }

        // Get and validate dog's weight
        String weight;
        while (true) {
            System.out.println("What is the dog's weight? (example: 25.6)");
            weight = scanner.nextLine().trim();
            if (checkQuit(weight)) {
                System.out.println("Intake cancelled.");
                return;
            }
            if (weight.matches("\\d+(\\.\\d+)?")) {
                break;
            } else {
                System.out.println("Invalid weight. Please enter a numeric value.");
            }
        }

        // Get and validate acquisition date
        String date;
        while (true) {
            System.out.println("What is the dog's acquisition date? (MM-DD-YYYY)");
            date = scanner.nextLine().trim();
            if (checkQuit(date)) {
                System.out.println("Intake cancelled.");
                return;
            }
            if (date.matches("(0[1-9]|1[0-2])-([0-2][0-9]|3[01])-\\d{4}")) {
                break;
            } else {
                System.out.println("Invalid date format. Please use MM-DD-YYYY.");
            }
        }

        // Get and validate acquisition country
        String country;
        while (true) {
            System.out.println("What is the dog's acquisition country?");
            country = scanner.nextLine().trim();
            if (checkQuit(country)) {
                System.out.println("Intake cancelled.");
                return;
            }
            if (country.matches("(?i)[a-zA-Z\\s]+")) {
                break;
            } else {
                System.out.println("Invalid input. Country names should only contain letters and spaces.");
            }
        }

        // Get dog's training status
        String trainingStatus;
        while (true) {
            System.out.println("What is the dog's training status? (Options are: intake, Phase I, Phase II, in service.)");
            trainingStatus = scanner.nextLine().trim();
            if (checkQuit(trainingStatus)) {
                System.out.println("Intake cancelled.");
                return;
            }
            if (isValidTrainingStatus(trainingStatus))
                break;
            else
                System.out.println("Invalid training status. Please enter one of the valid options.");
        }

        // Validate true/false input for reserved
        boolean reserve = false;
        while (true) {
            System.out.println("Is the dog reserved? (true/false)");
            String reservedInput = scanner.nextLine().trim().toLowerCase();
            if (reservedInput.equals("true") || reservedInput.equals("false")) {
                reserve = Boolean.parseBoolean(reservedInput);
                break;
            } else {
                System.out.println("Please enter 'true' or 'false'.");
            }
        }

        // Get and validate service country
        String serviceCountry;
        while (true) {
            System.out.println("What is the dog's service country?");
            serviceCountry = scanner.nextLine().trim();
            if (checkQuit(serviceCountry)) {
                System.out.println("Intake cancelled.");
                return;
            }
            if (serviceCountry.matches("(?i)[a-zA-Z\\s]+")) {
                break;
            } else {
                System.out.println("Invalid input. Country names should only contain letters and spaces.");
            }
        }

        // Confirmation save
        if (confirmSave(scanner, "dog")) {
            dogList.add(new Dog(name, breed, gender, age, weight, date, country,
                    trainingStatus, reserve, serviceCountry));
            System.out.println("\n" + name + " (dog) has been successfully added to the system.");
        }
    }

    // Intake NewMonkey method
    public static void intakeNewMonkey(Scanner scanner) {
        boolean quit = false;
        while (!quit) {
            System.out.println("What is the monkey's name? (enter 'q' to quit)");
            String name = scanner.next();
            if (checkQuit(name)) {
                System.out.println("Intake cancelled.");
                return;
            }
            for (Monkey monkey : monkeyList) {
                if (monkey.getName().equalsIgnoreCase(name)) {
                    System.out.println("\n\nThis monkey is already in our system.\n\n");
                    return;
                }
            }

            // Get monkey species, only use capuchin, guenon, macaque, marmoset, squirrel monkey, tamarin
            System.out.println("What is the monkey's species?");
            System.out.println("Valid species include: capuchin, guenon, macaque, marmoset, squirrel monkey, tamarin.");
            String species = scanner.nextLine().toLowerCase();
            if (checkQuit(species)) {
                System.out.println("Intake cancelled.");
                return;
            }

            // validate input of monkey species
            if (!species.equals("capuchin") && !species.equals("guenon") && !species.equals("macaque")
                    && !species.equals("marmoset") && !species.equals("squirrel monkey")
                    && !species.equals("tamarin")) {
                System.out.println("\n\nThis monkey is not eligible for training.\n\n");
                return;
            }

            // Get monkey's gender
            System.out.println("What is the monkey's gender?");
            String gender = scanner.nextLine().trim();
            if (checkQuit(gender)) {
                System.out.println("Intake cancelled.");
                return;
            }

            // Get and validate monkey's age (numeric)
            String age;
            while (true) {
                System.out.println("What is the monkey's age? (example: 4)");
                age = scanner.nextLine().trim();
                if (checkQuit(age)) {
                    System.out.println("Intake cancelled.");
                    return;
                }
                if (age.matches("\\d+"))
                    break;
                else
                    System.out.println("Invalid age. Please enter a number.");
            }

            // Get and validate monkey's weight (numeric, decimal allowed)
            String weight;
            while (true) {
                System.out.println("What is the monkey's weight? (example: 14.5)");
                weight = scanner.nextLine().trim();
                if (checkQuit(weight)) {
                    System.out.println("Intake cancelled.");
                    return;
                }
                if (weight.matches("\\d+(\\.\\d+)?"))
                    break;
                else
                    System.out.println("Invalid weight. Please enter a numeric value.");
            }

            // Get and validate monkey's acquisition date (MM-DD-YYYY)
            String date;
            while (true) {
                System.out.println("What is the monkey's acquisition date? (MM-DD-YYYY)");
                date = scanner.nextLine().trim();
                if (checkQuit(date)) {
                    System.out.println("Intake cancelled.");
                    return;
                }
                if (date.matches("(0[1-9]|1[0-2])-([0-2][0-9]|3[01])-\\d{4}"))
                    break;
                else
                    System.out.println("Invalid date format. Please use MM-DD-YYYY.");
            }

            // Get and validate monkey's acquisition country (letters and spaces only)
            String country;
            while (true) {
                System.out.println("What is the monkey's acquisition country?");
                country = scanner.nextLine().trim();
                if (checkQuit(country)) {
                    System.out.println("Intake cancelled.");
                    return;
                }
                if (country.matches("[a-zA-Z\\s]+"))
                    break;
                else
                    System.out.println("Invalid input. Country names should only contain letters and spaces.");
            }

            // Get and validate monkey's training status
            String trainingStatus;
            while (true) {
                System.out.println("What is the monkey's training status? (Options are: intake, Phase I, Phase II, in service.)");
                trainingStatus = scanner.nextLine().trim();
                if (checkQuit(trainingStatus)) {
                    System.out.println("Intake cancelled.");
                    return;
                }
                if (isValidTrainingStatus(trainingStatus))
                    break;
                else
                    System.out.println("Invalid training status. Please enter one of the valid options.");
            }

            // Get and validate monkey's reserved status
            boolean reserve = false;
            while (true) {
                System.out.println("Is the monkey reserved? (true/false)");
                String reservedInput = scanner.nextLine().trim().toLowerCase();
                if (reservedInput.equals("true") || reservedInput.equals("false")) {
                    reserve = Boolean.parseBoolean(reservedInput);
                    break;
                } else {
                    System.out.println("Please enter 'true' or 'false'.");
                }
            }

            // Get and validate monkey's service country (letters and spaces only)
            String serviceCountry;
            while (true) {
                System.out.println("What is the monkey's service country?");
                serviceCountry = scanner.nextLine().trim();
                if (checkQuit(serviceCountry)) {
                    System.out.println("Intake cancelled.");
                    return;
                }
                if (serviceCountry.matches("[a-zA-Z\\s]+"))
                    break;
                else
                    System.out.println("Invalid input. Country names should only contain letters and spaces.");
            }

            // Get and validate monkey's body length (integer)
            int bodyLength = 0;
            while (true) {
                System.out.println("What is the monkey's body length? (integer value)");
                String input = scanner.nextLine().trim();
                if (checkQuit(input)) {
                    System.out.println("Intake cancelled.");
                    return;
                }
                try {
                    bodyLength = Integer.parseInt(input);
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter an integer value.");
                }
            }

            // Get and validate monkey's tail length (integer)
            int tailLength = 0;
            while (true) {
                System.out.println("What is the monkey's tail length? (integer value)");
                String input = scanner.nextLine().trim();
                if (checkQuit(input)) {
                    System.out.println("Intake cancelled.");
                    return;
                }
                try {
                    tailLength = Integer.parseInt(input);
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter an integer value.");
                }
            }

            // Get and validate monkey's height (integer)
            int height = 0;
            while (true) {
                System.out.println("What is the monkey's height? (example: 13)");
                String input = scanner.nextLine().trim();
                if (checkQuit(input)) {
                    System.out.println("Intake cancelled.");
                    return;
                }
                try {
                    height = Integer.parseInt(input);
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter an integer value.");
                }
            }

            // Confirm saving the new monkey before adding to the list
            if (confirmSave(scanner, "monkey")) {
                monkeyList.add(new Monkey(name, gender, age, weight, date, country,
                        trainingStatus, reserve, serviceCountry, bodyLength, tailLength, height, species));
                System.out.println("\n" + name + " (monkey) has been successfully added to the system.");
            }
        }
    }
}