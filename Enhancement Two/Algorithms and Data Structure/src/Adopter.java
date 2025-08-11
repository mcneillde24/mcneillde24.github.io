//method for adopter to choose species, experience level and energy level
public class Adopter {
    private String preferredSpecies;
    private int experienceLevel; // level 1 to level 5
    private String preferredEnergyLevel; //low, medium, high

    // Initialize adopter prefences on species, experience level and energy level
    public Adopter(String preferredSpecies, int experienceLevel, String preferredEnergyLevel) {
       this.preferredSpecies = preferredSpecies.toLowerCase();
        this.experienceLevel = experienceLevel;
        this.preferredEnergyLevel = preferredEnergyLevel.toLowerCase(); 
    }
    // getter for preferred species
    public String getPreferredSpecies() {
        return preferredSpecies;
    }
    // getter for experience level
    public int getExperienceLevel() {
        return experienceLevel;
    }
    // getter for preferred energy level
    public String getPreferredEnergyLevel() {
        return preferredEnergyLevel;
    }
}
