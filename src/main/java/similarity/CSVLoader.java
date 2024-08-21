package similarity;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVLoader {

    // Metoda za učitavanje baze računara iz CSV fajla
    public List<Computer> loadComputersFromCSV(String filePath) throws IOException {
        List<Computer> computerList = new ArrayList<>();

        // Čitaj CSV fajl red po red
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;

            // Preskoči prvu liniju ako sadrži naslove kolona
            br.readLine(); 

            // Parsiraj svaku liniju i dodaj računar u listu
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                
                // Pretpostavljamo da CSV sadrži redosled: CPU, RAM, Storage, GPU, Chipset
                String cpu = values[0];
                int ram = Integer.parseInt(values[1]);
                int storageSize = Integer.parseInt(values[2]);
                String gpu = values[3];
                String chipset = values[4];

                // Kreiraj Computer objekat
                Computer computer = new Computer(cpu, ram, storageSize, gpu, chipset);

                // Dodaj računar u listu
                computerList.add(computer);
            }
        }

        return computerList;
    }
}
