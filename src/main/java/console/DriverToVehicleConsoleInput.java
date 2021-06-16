package console;


import domain.DriverToVehicle;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class DriverToVehicleConsoleInput extends ConsoleInput<DriverToVehicle>{
    Scanner scanner = new Scanner(System.in);
    @Override
    public DriverToVehicle input() {
        System.out.println("Введите ID водителя: ");
        int driverId = scanner.nextInt();
        System.out.println("Введите ID автомобиля: ");
        int vehicleId = scanner.nextInt();
        return new DriverToVehicle(driverId, vehicleId);
    }

    @Override
    public List<DriverToVehicle> inputAll() {
        String answer;
        List<DriverToVehicle> driverToVehicles = new ArrayList<>();
        do {
            driverToVehicles.add(input());
            System.out.print("Продолжить добавление?(yes/no): ");
            answer = scanner.next();
        } while (answer.toLowerCase(Locale.ROOT).contains("yes"));
        return driverToVehicles;
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
    public DriverToVehicle inputDataToChangeObject() {
        System.out.print("Введите ID модели автомобиля: ");
        int carId = scanner.nextInt();
        System.out.print("Введите ID водителя: ");
        int driverId = scanner.nextInt();
        return new DriverToVehicle(carId, driverId);
    }
}
