package console;

import domain.Vehicle;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class VehicleConsoleInput extends ConsoleInput{
    Scanner scanner = new Scanner(System.in);
    private int modelId;
    private String governmentNumber;
    @Override
    public Vehicle input() {
        System.out.println("Введите наименование модели: ");
        modelId = scanner.nextInt();
        System.out.println("Введите гос.номер автомобиля: ");
        governmentNumber = scanner.nextLine();
        return new Vehicle(modelId, governmentNumber);
    }

    @Override
    public List<Vehicle> inputAll() {
        String answer;
        List<Vehicle> vehicles = new ArrayList<>();
        do {
            vehicles.add(input());
            System.out.print("Продолжить добавление?(yes/no): ");
            answer = scanner.nextLine();
        } while (answer.toLowerCase(Locale.ROOT).contains("yes"));
        return vehicles;
    }
}
