package console;


import domain.Dv_m2m;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Dv_m2mConsoleInput extends ConsoleInput<Dv_m2m>{
    Scanner scanner = new Scanner(System.in);
    @Override
    public Dv_m2m input() {
        System.out.println("Введите ID водителя: ");
        int driverId = scanner.nextInt();
        System.out.println("Введите ID автомобиля: ");
        int vehicleId = scanner.nextInt();
        return new Dv_m2m(driverId, vehicleId);
    }

    @Override
    public List<Dv_m2m> inputAll() {
        String answer;
        List<Dv_m2m> Dv_m2ms = new ArrayList<>();
        do {
            Dv_m2ms.add(input());
            System.out.print("Продолжить добавление?(yes/no): ");
            answer = scanner.nextLine();
        } while (answer.toLowerCase(Locale.ROOT).contains("yes"));
        return Dv_m2ms;
    }
}
