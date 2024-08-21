package fuzzysystem;

import net.sourceforge.jFuzzyLogic.FIS;

public class FuzzySystemDAO {

    // Ова метода сада прима апсолутни пут до .fcl датотеке
    public double evaluateComputer(String fileName, int cpuCores, int memorySize, int diskSpeed, int powerSupply, String usageType, String gpuModel) {
        
        // Учитавање .fcl датотеке
        FIS fis = FIS.load(fileName, true);

        if (fis == null) {
            System.err.println("Cannot load file: " + fileName);
            return 0;
        }

        // Постављање улазних вредности у фази систем
        fis.setVariable("cores", cpuCores);          // Измена на "cores"
        fis.setVariable("ram", memorySize);          // Измена на "ram"
        fis.setVariable("storageSpeed", diskSpeed);  // Измена на "storageSpeed"
        fis.setVariable("powerSupply", powerSupply); // Измена на "powerSupply"

        // Претвори **gpuModel** у одговарајућу вредност за **gpuPower**
        double gpuPowerValue = convertGpuModelToPower(gpuModel);
        fis.setVariable("gpuPower", gpuPowerValue);  // Ово је већ у реду

        // Одређивање одговарајуће излазне променљиве на основу типa употребе
        String suitabilityVar = "";
        switch (usageType.toLowerCase()) {
            case "home":
                suitabilityVar = "homeUseSuitability";  // Усаглашено са .fcl
                break;
            case "business":
                suitabilityVar = "businessUseSuitability";  // Усаглашено са .fcl
                break;
            case "gaming":
                suitabilityVar = "gamingSuitability";  // Усаглашено са .fcl
                break;
            case "mining":
                suitabilityVar = "miningSuitability";  // Усаглашено са .fcl
                break;
            case "hosting":
                suitabilityVar = "hostingSuitability";  // Усаглашено са .fcl
                break;
            default:
                System.err.println("Unknown usage type: " + usageType);
                return 0;
        }

        // Извршење фази система
        fis.evaluate();

        // Преузимање резултата за одређену намену
        return fis.getVariable(suitabilityVar).getValue();
    }

 // Пример функције за претварање **gpuModel** у снагу графичке картице (gpuPower)
    private double convertGpuModelToPower(String gpuModel) {
        // Логика за конвертовање модела графичке картице у њену снагу.
        switch (gpuModel.toLowerCase()) {
            case "intel uhd 620":
                return 800;  // пример за овај модел
            case "nvidia rtx 3060":
                return 1500; // пример за овај модел
            case "amd radeon rx 580":
                return 1200; // пример за овај модел
            case "nvidia rtx 3080":
                return 1800; // пример за овај модел
            case "nvidia rtx 3090":
                return 2000; // пример за овај модел
            case "amd radeon rx 5700":
                return 1400; // пример за овај модел
            case "intel iris xe":
                return 900;  // додат овај модел
            case "nvidia quadro p4000":
                return 1600; // пример за овај модел
            case "amd radeon pro wx 3200":
                return 1100; // пример за овај модел
            case "nvidia quadro rtx 4000":
                return 1700; // пример за овај модел
            default:
                System.err.println("Unknown GPU model: " + gpuModel);
                return 1000; // подразумевана вредност ако модел није препознат
        }
    }

}
