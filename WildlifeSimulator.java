/**
 * WildlifeSimulator - Manages population dynamics for multiple species
 * Uses an array of Species objects to store and simulate species data
 */
public class WildlifeSimulator {
    private Species[] species;
    private int speciesCount;
    
    public WildlifeSimulator(int maxSpecies) {
        // initialize species array and species count
        species = new Species[maxSpecies];
        speciesCount = 0;
    }
    
    /**
     * Add a species to the simulator
     */
    public void addSpecies(Species s) {
        if (speciesCount >= species.length) {
            throw new IllegalStateException("Cannot add more species. Array is full.");
        }
        species[speciesCount] = s;
        speciesCount++;
    }
    
    /**
     * Simulate one year of population changes for all species
     */
    public void simulateYear() {
        for (int i = 0; i < speciesCount; i++) {
            species[i].simulateYear();
        }
    }
    
    /**
     * Simulate multiple years
     */
    public void simulate(int years) {
        for (int i = 0; i < years; i++) {
            simulateYear();
        }
    }

    public void writeYear(int year) {
        System.out.println("Year: " + year);
        for (int i = 0; i < speciesCount; i++) {
            System.out.println(species[i]);
        }
    }

    /**
     * Get species at given index
     */
    public Species getSpecies(int index) {
        if (index < 0 || index >= speciesCount) {
            throw new IllegalArgumentException("Invalid species index.");
        }
        return species[index];
    }
    
    /**
     * Get species info as formatted string
     */
    public String getSpeciesInfo(int index) {
        return getSpecies(index).toString();
    }
    
    /**
     * Get total wildlife count across all species
     */
    public double getTotalPopulation() {
        double total = 0;
        for (int i = 0; i < speciesCount; i++) {
            total += species[i].getPopulation();
        }
        return total;
    }
    
    /**
     * Find the species with largest population
     */
    public int getMostPopulousIndex() {
        if (speciesCount == 0) {
            return -1;
        }

        int maxPopIndex = 0;
        for (int i = 1; i < speciesCount; i++) {
            if (species[i].getPopulation() > species[maxPopIndex].getPopulation()) {
                maxPopIndex = i;
            }
        }
        return maxPopIndex;
    }
    
    /**
     * Find the species with smallest population (most endangered)
     */
    public int getMostEndangeredIndex() {
        if (speciesCount == 0) {
            return -1;
        }

        int minPopIndex = 0;
        for (int i = 1; i < speciesCount; i++) {
            if (species[i].getPopulation() < species[minPopIndex].getPopulation()) {
                minPopIndex = i;
            }
        }
        return minPopIndex;
    }
    
    public int getSpeciesCount() {
        return speciesCount;
    }

    public String toString() {
        String result = "";
        for (int i = 0; i < speciesCount; i++) {
            result += species[i].toString() + "\n";
        }
        return result;
    }
    
    /**
     * Get array of all species
     */
    public Species[] getSpeciesArray() {
        return species;
    }
}