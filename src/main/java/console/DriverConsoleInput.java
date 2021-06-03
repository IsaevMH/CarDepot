package console;

import domain.Driver;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class DriverConsoleInput extends ConsoleInput<Driver>{
    Scanner scanner = new Scanner(System.in);
    private String name;
    private int experience;

    @Override
    public Driver input() {
        System.out.println("Введите ФИО водителя: ");
        name = scanner.nextLine();
        System.out.println("Введите стаж водителя: ");
        experience = scanner.nextInt();
        return new Driver(name, experience);
    }

    @Override
    public List<Driver> inputAll() {
        String answer;
        List<Driver> drivers = new ArrayList<>();
        do {
            drivers.add(input());
            System.out.print("Продолжить добавление?(yes/no): ");
            answer = scanner.nextLine();
        } while (answer.toLowerCase(Locale.ROOT).contains("yes"));
        return drivers;
    }
}