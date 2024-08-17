package similaritysearch;

public class Computer {
    private String processor;
    private double processorSpeedGHz;
    private int ramGB;
    private int storageGB;
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

    // Гетери за сва поља
    public String getProcessor() {
        return processor;
    }

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
