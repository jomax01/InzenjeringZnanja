package similaritysearch;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

public class CaseBase {
    public List<Computer> computers;

    public CaseBase() {
        computers = new ArrayList<>();

        try {
            loadComputersFromCSV("resources/Database.csv");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadComputersFromCSV(String filePath) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean firstLine = true; // Za preskakanje zaglavlja

            while ((line = br.readLine()) != null) {
                if (firstLine) {
                    firstLine = false;
                    continue; // Preskoči zaglavlje
                }

                String[] values = line.split(","); // CSV vrednosti odvojene zarezom
                String processor = values[0];
                double processorSpeed = Double.parseDouble(values[1]);
                int ram = Integer.parseInt(values[2]);
                int storage = Integer.parseInt(values[3]);
                String gpu = values[4];
                String chipset = values[5];

                Computer computer = new Computer(processor, processorSpeed, ram, storage, gpu, chipset);
                computers.add(computer);
            }
        }
=======
        
        // Додавање рачунара у базу
        computers.add(new Computer("Intel Core i5 10200H", 4.1, 8, 512, "nVidia GeForce GTX 1650", "Intel Comet Lake-H Refresh SOC"));
        computers.add(new Computer("Intel Core i3 1005G1", 3.4, 16, 512, "Intel UHD G1", "Intel Ice Lake SoC"));
        computers.add(new Computer("Intel Core i5 Quad Core 1135G7", 4.1, 8, 256, "Intel Iris Xe Graphics G7", "Intel Tiger Lake-U SOC"));
        computers.add(new Computer("Intel Core i3 10110U", 4.1, 8, 256, "Intel UHD 620", "Intel Comet Lake-U SOC"));
        computers.add(new Computer("Intel Core i7 10750H", 5.0, 16, 1024, "nVidia RTX 2070", "Intel Comet Lake-H"));
        // Додајте више рачунара у базу по потреби
>>>>>>> 5744d0de1705c5998c521d8ac9f60450796d820b
    }

    public List<Computer> findSimilarComputers(Computer inputComputer) {
        List<Computer> similarComputers = new ArrayList<>();
<<<<<<< HEAD
        double similarityThreshold = 0.3; // Prag sličnosti smanjen na 0.3
=======
        double similarityThreshold = 0.5; // Смањен праг сличности на 50%
>>>>>>> 5744d0de1705c5998c521d8ac9f60450796d820b

        for (Computer computer : computers) {
            double similarity = inputComputer.calculateSimilarity(computer);
            if (similarity >= similarityThreshold) {
                similarComputers.add(computer);
            }
        }
        return similarComputers;
    }
<<<<<<< HEAD
=======

    public void addComputer(Computer computer) {
        computers.add(computer);
    }
>>>>>>> 5744d0de1705c5998c521d8ac9f60450796d820b
}
