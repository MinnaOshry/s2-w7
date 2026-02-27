import java.io.*;
import java.util.*;

/**
 * WildlifeSimulatorApp - Main program for the Wildlife Population Simulator
 * 
 * This program:
 * 1. Reads real species data from a CSV file using split()
 * 2. Creates Species objects from the data
 * 3. Simulates population changes over time
 * 4. Writes results to an output CSV file
 */
public class WildlifeSimulatorRunner {
    
    public static void main(String[] args) throws IOException {
        // Create simulator with capacity for 20 species
        WildlifeSimulator simulator= new WildlifeSimulator(20);
        
        // Load species data from CSV
        File f = new File("species-data.csv");
        Scanner s = new Scanner(f);
         s.nextLine();
        while(s.hasNextLine()){
           
            String line = s.nextLine();
            String[] pieces = line.split(",");
            System.out.println(line);
            String spName = pieces[0];
            int pop = Integer.parseInt(pieces[1]);
            double birthRate = Double.parseDouble(pieces[2]);
            double deathRate = Double.parseDouble(pieces[3]);
            int capacity = Integer.parseInt(pieces[4]);
            
            String location = pieces[5];
            Species temp = new Species(spName, pop, birthRate, deathRate, capacity, location);
            simulator.addSpecies(temp);
            System.out.println(line);



        }


        System.out.println("\n========================================");
        System.out.println("WILDLIFE POPULATION SIMULATOR");
        System.out.println("========================================\n");
        
        
        // Display initial populations
        System.out.println("INITIAL POPULATIONS:");
        System.out.println("------------------");
        System.out.println(simulator);
        
        // Run simulation for 10 years and record data year-by-year
        int simulationYears = 10;
        
        
        // Display final populations
        
        
        // Display statistics
        System.out.println("\n\nSIMULATION STATISTICS:");
        System.out.println("------------------");
        int mostPopulous = simulator.getMostPopulousIndex();
        int mostEndangered = simulator.getMostEndangeredIndex();
        
        
                
        System.out.println("\nSimulation complete!");
    }
    
    /**
     * Load species data from CSV file into the simulator
     * CSV format: name,population,birthRate,deathRate,capacity,location
     */
    private static void loadSpeciesFromCSV(WildlifeSimulator simulator, String filename) {
        //TODO
    }
    
    /**
     * Simulate year-by-year and record data to CSV file
     * Writes: simulation_year,species,population,population_change
     */
    private static void simulateAndRecordData(WildlifeSimulator simulator, int years, String filename) {
        //TODO
    
    }    
    
}