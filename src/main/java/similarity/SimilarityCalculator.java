package similarity;

public class SimilarityCalculator {

    // Metoda za izračunavanje sličnosti između dva računara
    public double calculateSimilarity(Computer c1, Computer c2) {
        double similarity = 0.0;

        // Izračunaj sličnost za CPU
        if (c1.getCpu().equalsIgnoreCase(c2.getCpu())) {
            similarity += 0.2; // 20% težine za CPU
        }

        // Izračunaj sličnost za RAM
        similarity += calculatePercentageSimilarity(c1.getRam(), c2.getRam()) * 0.2;

        // Izračunaj sličnost za veličinu skladišta
        similarity += calculatePercentageSimilarity(c1.getStorageSize(), c2.getStorageSize()) * 0.2;

        // Izračunaj sličnost za GPU
        if (c1.getGpu().equalsIgnoreCase(c2.getGpu())) {
            similarity += 0.2; // 20% težine za GPU
        }

        // Izračunaj sličnost za chipset
        if (c1.getChipset().equalsIgnoreCase(c2.getChipset())) {
            similarity += 0.2; // 20% težine za chipset
        }

        return similarity; // Vraća vrednost između 0 i 1
    }

    // Pomoćna metoda za izračunavanje procentualne sličnosti između dva broja
    private double calculatePercentageSimilarity(int value1, int value2) {
        int max = Math.max(value1, value2);
        int min = Math.min(value1, value2);
        return (double) min / max;
    }
}
