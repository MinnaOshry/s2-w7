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
        //TODO 1. call each species simulate year 
        // //loop species array, for each object do right thing
        
        for(int i = 0; i < speciesCount; i++) {
            species[i].simulateYear();
        }

    }
    
    /**
     * Simulate multiple years
     */
    public void simulate(int years) {
        //TODO //TODO 1. loop for years, 2 eacher year call simulate year 
        for (int i  =0; i<years; i++){
            simulateYear();
        }
    }
    
    /**
     * Get species at given index
     */
    public Species getSpecies(int index) {
        //TODO
        if (index>=this.species.length){
            throw new IllegalArgumentException(); 
        }
        return this.species[index];
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
        int pop = 0;
        for (Species s: species){
            if(s!=null){
                pop += s.getPopulation();
            }
        }
        return pop;
    }
    
    /**
     * Find the species with largest population
     */
    public int getMostPopulousIndex() {
        //TODO
        int maxPopIndex = 0;
        for( int x = 0; x<this.speciesCount; x++){
            if(this.species[maxPopIndex].getPopulation() < this.species[x].getPopulation()){
                maxPopIndex = x;
            }
        }
        return maxPopIndex;
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
            m+= s.toString()+"\n";

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
