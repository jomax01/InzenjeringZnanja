package similarity;

import java.util.ArrayList;
import java.util.List;

public class CaseRetrieval {
    
    // Metoda za pretragu najsličnijih računara iz baze
    public List<Computer> retrieveMostSimilar(Computer targetComputer, List<Computer> computerDatabase, int numberOfResults) {
        List<Computer> mostSimilarComputers = new ArrayList<>();
        SimilarityCalculator similarityCalculator = new SimilarityCalculator();

        // Kreiranje liste sličnosti za svaki računar u bazi
        List<SimilarityResult> similarityResults = new ArrayList<>();
        for (Computer c : computerDatabase) {
            double similarity = similarityCalculator.calculateSimilarity(targetComputer, c);
            similarityResults.add(new SimilarityResult(c, similarity));
        }

        // Sortiraj prema sličnosti (od najviše do najniže)
        similarityResults.sort((r1, r2) -> Double.compare(r2.getSimilarity(), r1.getSimilarity()));

        // Uzmi prvih 'numberOfResults' računara
        for (int i = 0; i < Math.min(numberOfResults, similarityResults.size()); i++) {
            mostSimilarComputers.add(similarityResults.get(i).getComputer());
        }

        return mostSimilarComputers;
    }

    // Pomoćna klasa za čuvanje rezultata sličnosti
    private class SimilarityResult {
        private Computer computer;
        private double similarity;

        public SimilarityResult(Computer computer, double similarity) {
            this.computer = computer;
            this.similarity = similarity;
        }

        public Computer getComputer() {
            return computer;
        }

        public double getSimilarity() {
            return similarity;
        }
    }
}
