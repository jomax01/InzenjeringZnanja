package fuzzylogic;

import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.rule.Variable;
import java.util.Scanner;

public class ComputerEvaluationFuzzyLogic {

    // Додајте main методу за самостално покретање
    @SuppressWarnings("resource")
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Унос података преко конзоле
        System.out.print("Унесите број језгара процесора: ");
        int cores = scanner.nextInt();

        System.out.print("Унесите капацитет RAM-а (GB): ");
        int ram = scanner.nextInt();

        System.out.print("Унесите брзину приступа диску (MB/s): ");
        int storageSpeed = scanner.nextInt();

        System.out.print("Унесите снагу графичке картице (MHz): ");
        int gpuPower = scanner.nextInt();

        System.out.print("Унесите снагу напајања (W): ");
        int powerSupply = scanner.nextInt();

        // Учитавање фази датотеке
        String fileName = "resources/computerEvaluation.fcl"; // Поставите апсолутни или релативни пут до ваше .fcl датотеке
        FIS fis = FIS.load(fileName, true);

        // Провера да ли је датотека правилно учитана
        if (fis == null) {
            System.err.println("Грешка при учитавању фази датотеке: " + fileName);
            return;
        }

        // Постављање улазних променљивих из унетих података
        fis.setVariable("cores", cores);
        fis.setVariable("ram", ram);
        fis.setVariable("storageSpeed", storageSpeed);
        fis.setVariable("gpuPower", gpuPower);
        fis.setVariable("powerSupply", powerSupply);

        // Извршавање фази система
        fis.evaluate();

        // Преузимање и приказ излазних променљивих
        Variable homeUse = fis.getVariable("homeUseSuitability");
        Variable businessUse = fis.getVariable("businessUseSuitability");
        Variable gamingUse = fis.getVariable("gamingSuitability");
        Variable miningUse = fis.getVariable("miningSuitability");
        Variable hostingUse = fis.getVariable("hostingSuitability");

     // Приказ резултата
        System.out.println("Погодност за кућну употребу: " + homeUse.getValue());
        System.out.println("Погодност за пословну употребу: " + businessUse.getValue());
        System.out.println("Погодност за играње игара: " + gamingUse.getValue());
        System.out.println("Погодност за рударење криптовалута: " + miningUse.getValue());
        System.out.println("Погодност за хостинг веб сајтова: " + hostingUse.getValue());


        scanner.close();
    }
}
