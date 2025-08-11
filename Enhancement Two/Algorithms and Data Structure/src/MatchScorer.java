// method to calculate the compatability ranking between adopter and rescue animal
/* 
 * Calculates this score using:
 * species match +3
 * experience +2
 * energy level +1
 */
public class MatchScorer {
    public static int calculateCompatibility(Adopter adopter, RescueAnimal animal) {
        int score = 0;
        // check if species is a match
        if (animal.getAnimalType().equalsIgnoreCase(adopter.getPreferredSpecies())) {
            score += 3;
        }
        // calculation of experience level based on animal's age
        try {
            int animalExp = Integer.parseInt(animal.getAge());
            if (adopter.getExperienceLevel() >= animalExp) {
                score += 2;
            }
        }
        // catch for invalid input
        catch (NumberFormatException e) {
            System.out.println("Invalid format for animal experience level.");
        }
        // caculation of energy level based on weight
        try {
            double weight = Double.parseDouble(animal.getWeight());
            String level = (weight > 50) ? "high" : (weight > 30 ? "medium" : "low");
            if (level.equals(adopter.getPreferredEnergyLevel())) {
                score += 1;
            }
        }
        // catch for invalid input
        catch (NumberFormatException e) {
            System.out.println("Invalid format for animal energy level.");
        }
        return score;
    }
}
