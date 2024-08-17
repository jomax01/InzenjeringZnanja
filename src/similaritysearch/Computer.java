package similaritysearch;

public class Computer {
    private String processor;
    private double processorSpeed;
    private int ram;
    private int storage;
    private String gpu;
    private String chipset;

    public Computer(String processor, double processorSpeed, int ram, int storage, String gpu, String chipset) {
        this.processor = processor;
        this.processorSpeed = processorSpeed;
        this.ram = ram;
        this.storage = storage;
        this.gpu = gpu;
        this.chipset = chipset;
    }

    public double calculateSimilarity(Computer other) {
        double similarity = 0.0;
        
        // Poređenje procesora
        if (this.processor.equalsIgnoreCase(other.processor)) {
            similarity += 0.2;
        }
        
        // Poređenje brzine procesora (relativna razlika)
        similarity += 0.2 * (1 - Math.abs(this.processorSpeed - other.processorSpeed) / Math.max(this.processorSpeed, other.processorSpeed));

        // Poređenje RAM-a (relativna razlika)
        similarity += 0.2 * (1 - Math.abs(this.ram - other.ram) / (double)Math.max(this.ram, other.ram));

        // Poređenje skladišta (relativna razlika)
        similarity += 0.2 * (1 - Math.abs(this.storage - other.storage) / (double)Math.max(this.storage, other.storage));

        // Poređenje grafičke kartice
        if (this.gpu.equalsIgnoreCase(other.gpu)) {
            similarity += 0.2;
        }

        return similarity;
    }

    public String getProcessor() {
        return processor;
    }

    @Override
    public String toString() {
        return "Procesor: " + processor + ", Brzina: " + processorSpeed + "GHz, RAM: " + ram + "GB, Skladište: " + storage + "GB, GPU: " + gpu + ", Čipset: " + chipset;
    }
}
