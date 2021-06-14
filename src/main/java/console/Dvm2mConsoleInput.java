package console;


import domain.Dvm2m;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Dvm2mConsoleInput extends ConsoleInput<Dvm2m>{
    Scanner scanner = new Scanner(System.in);
    @Override
    public Dvm2m input() {
        System.out.println("Введите ID водителя: ");
        int driverId = scanner.nextInt();
        System.out.println("Введите ID автомобиля: ");
        int vehicleId = scanner.nextInt();
        return new Dvm2m(driverId, vehicleId);
    }

    @Override
    public List<Dvm2m> inputAll() {
        String answer;
        List<Dvm2m> dvm2MS = new ArrayList<>();
        do {
            dvm2MS.add(input());
            System.out.print("Продолжить добавление?(yes/no): ");
            answer = scanner.nextLine();
        } while (answer.toLowerCase(Locale.ROOT).contains("yes"));
        return dvm2MS;
    }

    @Override
    public long inputIdToRemove() {
        System.out.print("Введите ID связи автомобиля и водителя, для ее удаления: ");
        long id = scanner.nextLong();
        return id;
    }

    @Override
    public long inputIdToShow() {
        System.out.print("Введите ID связи автомобиля и водителя, для ее демонстрации: ");
        long id = scanner.nextLong();
        return id;
    }

    @Override
    public Dvm2m inputDataToChangeObject() {
        System.out.print("Введите ID модели автомобиля: ");
        int carId = scanner.nextInt();
        System.out.print("Введите ID модели автомобиля: ");
        int driverId = scanner.nextInt();
        return new Dvm2m(carId, driverId);
    }
}
