package console;

import domain.Driver;
import domain.Vehicle;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class VehicleConsoleInput extends ConsoleInput<Vehicle>{
    Scanner scanner = new Scanner(System.in);

    @Override
    public Vehicle input() {
        System.out.println("Введите наименование модели: ");
        int modelId = scanner.nextInt();
        System.out.println("Введите гос.номер автомобиля: ");
        String governmentNumber = scanner.next();
        return new Vehicle(modelId, governmentNumber);
    }

    @Override
    public List<Vehicle> inputAll() {
        String answer;
        List<Vehicle> vehicles = new ArrayList<>();
        do {
            vehicles.add(input());
            System.out.print("Продолжить добавление?(yes/no): ");
            answer = scanner.next();
        } while (answer.toLowerCase(Locale.ROOT).contains("yes"));
        return vehicles;
    }

    @Override
    public long inputIdToRemove() {
        System.out.print("Введите ID транспорта, для его удаления: ");
        long id = scanner.nextLong();
        return id;
    }

    @Override
    public long inputIdToShow() {
        System.out.print("Введите ID транспорта, для его демонстрации: ");
        long id = scanner.nextLong();
        return id;
    }

    @Override
    public Vehicle inputDataToChangeObject() {
        System.out.print("Введите ID модели транспорта: ");
        int idModel = scanner.nextInt();
        System.out.print("Введите гос.номер авто: ");
        String governmentNumber = scanner.next();
        return new Vehicle(idModel,governmentNumber);
    }
}
