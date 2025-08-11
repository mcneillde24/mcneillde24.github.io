import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.sql.*;

public class AnimalManager {
    // create array to store data for dog and monkey objects
    private static ArrayList<Dog> dogList = new ArrayList<Dog>();
    private static ArrayList<Monkey> monkeyList = new ArrayList<Monkey>();

    public AnimalManager() {
        // pre-load some initial animals
        initializeDogList();
        initializeMonkeyList();
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

    }

    // initialize monkeyList Method
    public static void initializeMonkeyList() {

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
            System.out.println(
                    "What is the dog's training status? (Options are: intake, Phase I, Phase II, in service.)");
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
            Dog newDog = new Dog(name, breed, gender, age, weight, date, country,
                    trainingStatus, reserve, serviceCountry);
            insertAnimalToDB(newDog);
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

            // Get monkey species, only use capuchin, guenon, macaque, marmoset, squirrel
            // monkey, tamarin
            System.out.println("What is the monkey's species?");
            System.out.println("Valid species include: capuchin, guenon, macaque, marmoset, squirrel monkey, tamarin.");
            scanner.nextLine();
            String species = scanner.nextLine().trim().toLowerCase();
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
                System.out.println(
                        "What is the monkey's training status? (Options are: intake, Phase I, Phase II, in service.)");
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
                Monkey newMonkey = new Monkey(name, gender, age, weight, date, country,
                        trainingStatus, reserve, serviceCountry, bodyLength, tailLength, height, species);
                insertAnimalToDB(newMonkey);
                return;
            }
        }
    }

    // Method to insert RescueAnimal into the Animals table in the database
    public static void insertAnimalToDB(RescueAnimal animal) {
        // SQL insert statement with query
        String sql = "INSERT INTO Animals(name, species, gender, age, weight, acquisitionDate, acquisitionCountry, trainingStatus, reserved, inServiceCountry, breed, bodyLength, tailLength, height, monkeySpecies) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        // Makes sure the connection and statement close
        try (Connection conn = DBConnection.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            // Set values using data from the RescueAnimal
            pstmt.setString(1, animal.getName());
            pstmt.setString(2, animal.getAnimalType());
            pstmt.setString(3, animal.getGender());
            pstmt.setString(4, animal.getAge());
            pstmt.setString(5, animal.getWeight());
            pstmt.setString(6, animal.getAcquisitionDate());
            pstmt.setString(7, animal.getAcquisitionCountry());
            pstmt.setString(8, animal.getTrainingStatus());
            pstmt.setBoolean(9, animal.getReserved());
            pstmt.setString(10, animal.getInServiceCountry());

            // set default attributes that do not apply to both animal types
            String breed = null;
            Integer bodyLength = null;
            Integer tailLength = null;
            Integer height = null;
            String monkeySpecies = null;

            // else if statements for breed, body length, tail length, height, and species
            if (animal instanceof Dog) {
                Dog dog = (Dog) animal;
                breed = dog.getBreed();
            } else if (animal instanceof Monkey) {
                Monkey monkey = (Monkey) animal;
                bodyLength = monkey.getBodyLength();
                tailLength = monkey.getTailLength();
                height = monkey.getHeight();
                monkeySpecies = monkey.getSpecies();
            }

            // Set breed for dogs, null for monkeys
            pstmt.setString(11, breed);

            // Set bodyLength, tailLength, height for monkeys, null for dogs
            if (bodyLength != null) {
                pstmt.setInt(12, bodyLength);
                pstmt.setInt(13, tailLength);
                pstmt.setInt(14, height);
            } else {
                pstmt.setNull(12, Types.INTEGER);
                pstmt.setNull(13, Types.INTEGER);
                pstmt.setNull(14, Types.INTEGER);
            }

            // Set monkey species for monkeys, null for dogs
            pstmt.setString(15, monkeySpecies);

            // execute the insert statement
            pstmt.executeUpdate();
            System.out.println(animal.getAnimalType() + " " + animal.getName() + " saved to database.");
        } catch (SQLException e) {
            // Print error if SQL insert fails
            System.out.println("Database insert failed: " + e.getMessage());
        }
    }

    // Method to get list of dog attributes from the database
    public static List<Dog> getDogList() {
        List<Dog> dogs = new ArrayList<>();
        // select only species that match dog in database
        String sql = "SELECT * FROM Animals WHERE species = 'dog'";

        try (Connection conn = DBConnection.connect();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Dog dog = new Dog(
                        rs.getString("name"),
                        rs.getString("breed"),
                        rs.getString("gender"),
                        rs.getString("age"),
                        rs.getString("weight"),
                        rs.getString("acquisitionDate"),
                        rs.getString("acquisitionCountry"),
                        rs.getString("trainingStatus"),
                        rs.getBoolean("reserved"),
                        rs.getString("inServiceCountry"));
                dogs.add(dog);
            }

        } catch (SQLException e) {
            // Print error if dogs cannot be retrieved
            System.out.println("Error retrieving dogs: " + e.getMessage());
        }
        return dogs; // return the list
    }

    // Method to get list of monkey attributes from the database
    public static List<Monkey> getMonkeyList() {
        List<Monkey> monkeys = new ArrayList<>();
        // select only species that match monkey in database
        String sql = "SELECT * FROM Animals WHERE species = 'monkey'";

        try (Connection conn = DBConnection.connect();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Monkey monkey = new Monkey(
                        rs.getString("name"),
                        rs.getString("gender"),
                        rs.getString("age"),
                        rs.getString("weight"),
                        rs.getString("acquisitionDate"),
                        rs.getString("acquisitionCountry"),
                        rs.getString("trainingStatus"),
                        rs.getBoolean("reserved"),
                        rs.getString("inServiceCountry"),
                        rs.getInt("bodyLength"),
                        rs.getInt("tailLength"),
                        rs.getInt("height"),
                        rs.getString("monkeySpecies"));
                monkeys.add(monkey);
            }

        } catch (SQLException e) {
            // Print error if monkeys cannot be retrieved
            System.out.println("Error retrieving monkeys: " + e.getMessage());
        }
        return monkeys; // return the list
    }
}