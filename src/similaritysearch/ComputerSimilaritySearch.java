package similaritysearch;

import java.util.List;
<<<<<<< HEAD
import java.util.Scanner;

public class ComputerSimilaritySearch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Unos podataka o računaru
        System.out.print("Unesite naziv procesora: ");
        String processor = scanner.nextLine();

        System.out.print("Unesite brzinu procesora (GHz): ");
        double processorSpeed = scanner.nextDouble();

        System.out.print("Unesite kapacitet RAM-a (GB): ");
        int ram = scanner.nextInt();

        System.out.print("Unesite kapacitet skladišta (GB): ");
        int storage = scanner.nextInt();
        scanner.nextLine(); // Za hvatanje nove linije nakon int

        System.out.print("Unesite naziv grafičke kartice: ");
        String gpu = scanner.nextLine();

        System.out.print("Unesite naziv čipseta: ");
        String chipset = scanner.nextLine();

        // Kreiranje novog računara na osnovu unetih podataka
        Computer inputComputer = new Computer(processor, processorSpeed, ram, storage, gpu, chipset);

        // Kreiranje baze slučajeva i traženje sličnih računara
        CaseBase caseBase = new CaseBase();
        List<Computer> similarComputers = caseBase.findSimilarComputers(inputComputer);

        // Prikaz sličnih računara
        if (similarComputers.isEmpty()) {
            System.out.println("Nema sličnih računara u bazi.");
        } else {
            for (Computer computer : similarComputers) {
                double similarity = inputComputer.calculateSimilarity(computer);
                System.out.println(computer.getProcessor() + ", Sličnost: " + similarity);
            }
        }

        scanner.close();
=======


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

>>>>>>> a2ba81450adc144cc5c62ccc17b8bfd42a3a2917
    }
}
