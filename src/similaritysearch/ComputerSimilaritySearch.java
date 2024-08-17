package similaritysearch;

import java.util.List;

public class ComputerSimilaritySearch {

    public static void main(String[] args) {
        // Улазни рачунар
        Computer inputComputer = new Computer("Intel Core i3 10110U", 4.1, 8, 256, "Intel UHD 620", "Intel Comet Lake-U SOC");

        // Претрага у бази случајева
        CaseBase caseBase = new CaseBase();

        // Додајте испис сличности за сваки рачунар у бази ради лакше дијагностике
        for (Computer computer : caseBase.computers) {
            double similarity = inputComputer.calculateSimilarity(computer);
            System.out.println("Процесор: " + computer.getProcessor() + ", Сличност: " + similarity);
        }

        // Проналажење сличних рачунара
        List<Computer> similarComputers = caseBase.findSimilarComputers(inputComputer);

        // Приказ сличних рачунара
        if (similarComputers.isEmpty()) {
            System.out.println("Нема сличних рачунара у бази.");
        } else {
            System.out.println("Слични рачунари:");
            for (Computer computer : similarComputers) {
                System.out.println("Процесор: " + computer.getProcessor() + ", RAM: " + computer.getRamGB() + "GB, Меморија: " + computer.getStorageGB() + "GB, GPU: " + computer.getGpu());
            }
        }
    }
}
