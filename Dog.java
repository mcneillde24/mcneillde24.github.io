
// dog class extends RescueAnimal class, adding in specific type
public class Dog extends RescueAnimal {

    // specific to dog breeds
    private String breed;

    // Constructor - calls parent and initializes dog specific attributes
    public Dog(String name, String breed, String gender, String age,
    String weight, String acquisitionDate, String acquisitionCountry,
	String trainingStatus, boolean reserved, String inServiceCountry) {
    	// calls superclass RescueAnimal constructor
        super(name, "dog", gender, age, weight, acquisitionDate, acquisitionCountry, trainingStatus, reserved, inServiceCountry);
        //set dog specific attributes
        setName(name);
        setBreed(breed);
        setGender(gender);
        setAge(age);
        setWeight(weight);
        setAcquisitionDate(acquisitionDate);
        setAcquisitionLocation(acquisitionCountry);
        setTrainingStatus(trainingStatus);
        setReserved(reserved);
        setInServiceCountry(inServiceCountry);

    }

    // Accessor Method for breed
    public String getBreed() {
        return breed;
    }

    // Mutator Method for breed
    public void setBreed(String dogBreed) {
        breed = dogBreed;
    }

}