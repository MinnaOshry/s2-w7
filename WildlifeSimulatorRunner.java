import java.io.*;
import java.util.*;

/**
 * WildlifeSimulatorRunner - Main program for the Wildlife Population Simulator
 */
public class WildlifeSimulatorRunner {
    
    public static void main(String[] args) throws IOException {
        WildlifeSimulator simulator = new WildlifeSimulator(20);

        // Load species from CSV
        loadSpeciesFromCSV(simulator, "species-data.csv");

        System.out.println("\n========================================");
        System.out.println("WILDLIFE POPULATION SIMULATOR");
        System.out.println("========================================\n");

        System.out.println("INITIAL POPULATIONS:");
        System.out.println("------------------");
        System.out.println(simulator);

        int simulationYears = 10;

        // Run simulation and record results
        simulateAndRecordData(simulator, simulationYears, "simulation-output.csv");

        System.out.println("\nFINAL POPULATIONS:");
        System.out.println("------------------");
        System.out.println(simulator);

        System.out.println("\nSIMULATION STATISTICS:");
        System.out.println("------------------");

        int mostPopulous = simulator.getMostPopulousIndex();
        int mostEndangered = simulator.getMostEndangeredIndex();

        if (mostPopulous != -1) {
            System.out.println("Most Populous Species: " + 
                simulator.getSpecies(mostPopulous));
        }

        if (mostEndangered != -1) {
            System.out.println("Most Endangered Species: " + 
                simulator.getSpecies(mostEndangered));
        }

        System.out.println("Total Wildlife Population: " + 
            simulator.getTotalPopulation());

        System.out.println("\nSimulation complete!");
    }

    /**
     * Load species data from CSV file into the simulator
     * CSV format: name,population,birthRate,deathRate,capacity,location
     */
    private static void loadSpeciesFromCSV(WildlifeSimulator simulator, String filename) throws IOException {
        File file = new File(filename);
        Scanner scanner = new Scanner(file);

        // Skip header line
        if (scanner.hasNextLine()) {
            scanner.nextLine();
        }

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] pieces = line.split(",");

            String spName = pieces[0];
            int pop = Integer.parseInt(pieces[1]);
            double birthRate = Double.parseDouble(pieces[2]);
            double deathRate = Double.parseDouble(pieces[3]);
            int capacity = Integer.parseInt(pieces[4]);
            String location = pieces[5];

            Species species = new Species(spName, pop, birthRate, deathRate, capacity, location);
            simulator.addSpecies(species);
        }

        scanner.close();
    }

    /**
     * Simulate year-by-year and record data to CSV file
     * Writes: simulation_year,species,population,population_change
     */
    private static void simulateAndRecordData(WildlifeSimulator simulator, int years, String filename) throws IOException {
        PrintWriter writer = new PrintWriter(new FileWriter(filename));

        // Write header
        writer.println("simulation_year,species,population,population_change");

        for (int year = 1; year <= years; year++) {

            // Store populations before simulation
            double[] previousPopulations = new double[simulator.getSpeciesCount()];
            for (int i = 0; i < simulator.getSpeciesCount(); i++) {
                previousPopulations[i] = simulator.getSpecies(i).getPopulation();
            }

            // Simulate one year
            simulator.simulateYear();

            // Record new data
            for (int i = 0; i < simulator.getSpeciesCount(); i++) {
                Species s = simulator.getSpecies(i);
                double newPopulation = s.getPopulation();
                double change = newPopulation - previousPopulations[i];

                writer.println(year + "," +
                        s.getName() + "," +
                        newPopulation + "," +
                        change);
            }
        }

        writer.close();
    }
}