package similaritysearch;

import java.util.ArrayList;
import java.util.List;

public class CaseBase {
    public List<Computer> computers;

    public CaseBase() {
        computers = new ArrayList<>();
        
        // Додавање рачунара у базу
        computers.add(new Computer("Intel Core i5 10200H", 4.1, 8, 512, "nVidia GeForce GTX 1650", "Intel Comet Lake-H Refresh SOC"));
        computers.add(new Computer("Intel Core i3 1005G1", 3.4, 16, 512, "Intel UHD G1", "Intel Ice Lake SoC"));
        computers.add(new Computer("Intel Core i5 Quad Core 1135G7", 4.1, 8, 256, "Intel Iris Xe Graphics G7", "Intel Tiger Lake-U SOC"));
        computers.add(new Computer("Intel Core i3 10110U", 4.1, 8, 256, "Intel UHD 620", "Intel Comet Lake-U SOC"));
        computers.add(new Computer("Intel Core i7 10750H", 5.0, 16, 1024, "nVidia RTX 2070", "Intel Comet Lake-H"));
        // Додајте више рачунара у базу по потреби
    }

    public List<Computer> findSimilarComputers(Computer inputComputer) {
        List<Computer> similarComputers = new ArrayList<>();
        double similarityThreshold = 0.5; // Смањен праг сличности на 50%

        for (Computer computer : computers) {
            double similarity = inputComputer.calculateSimilarity(computer);
            if (similarity >= similarityThreshold) {
                similarComputers.add(computer);
            }
        }
        return similarComputers;
    }

    public void addComputer(Computer computer) {
        computers.add(computer);
    }
}
