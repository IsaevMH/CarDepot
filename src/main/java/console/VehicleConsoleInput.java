package console;

import domain.Driver;
import domain.Vehicle;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VehicleConsoleInput extends ConsoleInput{
    Scanner scanner;
    @Override
    public Vehicle input() {
        scanner = new Scanner(System.in);
        String model, type;
        List<Driver> drivers = new ArrayList<>();
        System.out.println("Введите наименование модели: ");
        model = scanner.nextLine();
        System.out.println("Введите тип кузова автомобиля: ");
        type = scanner.nextLine();
        return new Vehicle(model, type);
    }

    @Override
    public List<Vehicle> inputAll() {
        scanner = new Scanner(System.in);
        String model = "", type = "";
        List<Vehicle> vehicles = new ArrayList<>();
        do {
            System.out.println("Введите наименование модели: ");
            model = scanner.nextLine();
            System.out.println("Введите тип кузова автомобиля: ");
            type = scanner.nextLine();
        } while (model != "" || type != "");
        return vehicles;
    }
}
