package fuzzylogic;

import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.rule.Variable;

public class ComputerEvaluationFuzzyLogic {

    public static void main(String[] args) {
        // Учитавање фази датотеке
        String fileName = "resources/computerEvaluation.fcl"; // Поставите путању до ваше .fcl датотеке
        FIS fis = FIS.load(fileName, true);

        // Провера да ли је датотека правилно учитана
        if (fis == null) {
            System.err.println("Грешка при учитавању фази датотеке: " + fileName);
            return;
        }

        // Постављање улазних променљивих
        fis.setVariable("cores", 8); // Број језгара
        fis.setVariable("ram", 16);  // Капацитет радне меморије (GB)
        fis.setVariable("storageSpeed", 150); // Брзина приступа диску (MB/s)
        fis.setVariable("gpuPower", 1200);  // Снага графичке картице (MHz)
        fis.setVariable("powerSupply", 700);  // Снага напајања (W)

        // Извршавање фази система
        fis.evaluate();

        // Преузимање и приказ излазних променљивих
        Variable homeUse = fis.getVariable("homeUseSuitability");
        Variable businessUse = fis.getVariable("businessUseSuitability");
        Variable gamingUse = fis.getVariable("gamingSuitability");
        Variable miningUse = fis.getVariable("miningSuitability");
        Variable hostingUse = fis.getVariable("hostingSuitability");

        System.out.println("Погодност за кућну употребу: " + homeUse.getValue());
        System.out.println("Погодност за пословну употребу: " + businessUse.getValue());
        System.out.println("Погодност за играње игара: " + gamingUse.getValue());
        System.out.println("Погодност за рударење криптовалута: " + miningUse.getValue());
        System.out.println("Погодност за хостинг веб сајтова: " + hostingUse.getValue());
    }
}
