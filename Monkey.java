
public class Monkey extends RescueAnimal {
// Monkey specific attributes
	 public int bodyLength;
	 public int tailLength;
	 public int height;
	 public String species;
//Constructor for Monkey class
	 public Monkey(String name, String gender, String age, String weight, String acquisitionDate, String acquisitionCountry,
			 String trainingStatus, boolean reserved, String inServiceCountry,
			 int bodyLength, int tailLength, int height, String species) {
			 	super(name, "monkey", gender, age, weight, acquisitionDate, acquisitionCountry, trainingStatus, reserved, inServiceCountry);
			 this.bodyLength = bodyLength;
			 this.tailLength = tailLength;
			 this.height = height;
			 this.species = species;
			 }
//Accessors for attributes
public int getBodyLength() {
	return bodyLength;
}
public int getTailLength() {
	return tailLength;
}
public int getHeight() {
	return height;
}
public String getSpecies() {
	return species; 
}

//Mutators for attributes
public void setSpecies(String species) {
	this.species = species;
}
public void setTailLength(int tailLength) {
	this.tailLength = tailLength;
}
public void setHeight(int height) {
	this.height = height;
}
public void setBodyLength(int bodyLength){
	this.bodyLength = bodyLength;
}

}