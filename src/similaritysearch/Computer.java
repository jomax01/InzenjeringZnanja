package similaritysearch;

public class Computer {
    private String processor;

    private double processorSpeed;
    private int ram;
    private int storage;
    private String gpu;
    private String chipset;



    // Конструктор
    public Computer(String processor, double processorSpeedGHz, int ramGB, int storageGB, String gpu, String chipset) {
        this.processor = processor;
        this.processorSpeedGHz = processorSpeedGHz;
        this.ramGB = ramGB;
        this.storageGB = storageGB;
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


    // Гетери за сва поља

    public String getProcessor() {
        return processor;
    }


    @Override
    public String toString() {
        return "Procesor: " + processor + ", Brzina: " + processorSpeed + "GHz, RAM: " + ram + "GB, Skladište: " + storage + "GB, GPU: " + gpu + ", Čipset: " + chipset;

    public double getProcessorSpeedGHz() {
        return processorSpeedGHz;
    }

    public int getRamGB() {
        return ramGB;
    }

    public int getStorageGB() {
        return storageGB;
    }

    public String getGpu() {
        return gpu;
    }

    public String getChipset() {
        return chipset;
    }

    // Функција за израчунавање сличности између два рачунара
    public double calculateSimilarity(Computer other) {
        double similarity = 0.0;

        // Поређење процесора (једноставно поређење стринга)
        if (this.processor.equals(other.processor)) {
            similarity += 1;
        }

        // Поређење брзине процесора (нпр. разлика до 0.5GHz се сматра сличном)
        similarity += 1 - Math.abs(this.processorSpeedGHz - other.processorSpeedGHz) / 4.0;

        // Поређење RAM меморије
        similarity += 1 - Math.abs(this.ramGB - other.ramGB) / 32.0;

        // Поређење меморије за складиштење
        similarity += 1 - Math.abs(this.storageGB - other.storageGB) / 1000.0;

        // Поређење графичке картице
        if (this.gpu.equals(other.gpu)) {
            similarity += 1;
        }

        // Поређење чипсета
        if (this.chipset.equals(other.chipset)) {
            similarity += 1;
        }

        return similarity / 6.0; // Нормализација сличности на опсег [0, 1]

    }
}
