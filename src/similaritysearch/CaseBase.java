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
    }

    public List<Computer> findSimilarComputers(Computer inputComputer) {
        List<Computer> similarComputers = new ArrayList<>();
        double similarityThreshold = 0.3; // Prag sličnosti smanjen na 0.3

        for (Computer computer : computers) {
            double similarity = inputComputer.calculateSimilarity(computer);
            if (similarity >= similarityThreshold) {
                similarComputers.add(computer);
            }
        }
        return similarComputers;
    }
}
