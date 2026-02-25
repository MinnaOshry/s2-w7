/**
 * WildlifeSimulator - Manages population dynamics for multiple species
 * Uses an array of Species objects to store and simulate species data
 */
public class WildlifeSimulator {
    private Species[] species;
    private int speciesCount;
    
    public WildlifeSimulator(int maxSpecies) {
        //TODO: initialize species array, scanner set up, read file into species, call addspecies
        species = new Species[maxSpecies];
        

    }
    
    /**
     * Add a species to the simulator
     */
    public void addSpecies(Species s) {
        //TODO
        species[speciesCount] = s;
        speciesCount++;
    }
    
    /**
     * Simulate one year of population changes for all species
     */
    public void simulateYear() {
        //TODO
    }
    
    /**
     * Simulate multiple years
     */
    public void simulate(int years) {
        //TODO
    }
    
    /**
     * Get species at given index
     */
    public Species getSpecies(int index) {
        //TODO
        return null;
    }
    
    /**
     * Get species info as formatted string
     */
    public String getSpeciesInfo(int index) {
        return species[index].toString();
    }
    
    /**
     * Get total wildlife count across all species
     */
    public double getTotalPopulation() {
        //TODO
        return 0.0;
    }
    
    /**
     * Find the species with largest population
     */
    public int getMostPopulousIndex() {
        //TODO
        return -1;
    }
    
    /**
     * Find the species with smallest population (most endangered)
     */
    public int getMostEndangeredIndex() {
        //TODO
        return -1;
    }
    
    public int getSpeciesCount() {
        return speciesCount;
    }
    public String toString(){
        String m = "";
        for(Species s: species){
            if (s != null){
            m+= s.toString()+"/n";

            }

        }
        return m;
    }
    
    /**
     * Get array of all species
     */
    public Species[] getSpeciesArray() {
        return species;
    }
}
