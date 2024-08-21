package similarity;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Putanja do CSV datoteke
        String csvFilePath = "resources/Database.csv";

        // Kreiraj CSVLoader instancu i učitaj bazu računara
        CSVLoader csvLoader = new CSVLoader();
        List<Computer> computerDatabase;

        try {
            // Učitaj bazu računara iz CSV fajla
            computerDatabase = csvLoader.loadComputersFromCSV(csvFilePath);

            // Kreiraj target računar za koji tražimo slične
            Computer targetComputer = new Computer("Intel Core i3 10110U", 8, 256, "Intel UHD 620", "Intel Comet Lake-U SOC");

            // Kreiraj CaseRetrieval instancu
            CaseRetrieval caseRetrieval = new CaseRetrieval();

            // Pronađi najsličnije računare (npr. 3 rezultata)
            List<Computer> similarComputers = caseRetrieval.retrieveMostSimilar(targetComputer, computerDatabase, 3);

            // Prikaži slične računare
            System.out.println("Najbliži računari su:");
            for (Computer c : similarComputers) {
                System.out.println(c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
