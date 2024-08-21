package similarity;


public class Computer {
    private String cpu;
    private int ram;
    private int storageSize;
    private String gpu;
    private String chipset;

    // Konstruktor
    public Computer(String cpu, int ram, int storageSize, String gpu, String chipset) {
        this.cpu = cpu;
        this.ram = ram;
        this.storageSize = storageSize;
        this.gpu = gpu;
        this.chipset = chipset;
    }

    // Getteri i setteri
    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getStorageSize() {
        return storageSize;
    }

    public void setStorageSize(int storageSize) {
        this.storageSize = storageSize;
    }

    public String getGpu() {
        return gpu;
    }

    public void setGpu(String gpu) {
        this.gpu = gpu;
    }

    public String getChipset() {
        return chipset;
    }

    public void setChipset(String chipset) {
        this.chipset = chipset;
    }

    @Override
    public String toString() {
        return "CPU: " + cpu + ", RAM: " + ram + " GB, Storage: " + storageSize + " GB, GPU: " + gpu + ", Chipset: " + chipset;
    }
}

